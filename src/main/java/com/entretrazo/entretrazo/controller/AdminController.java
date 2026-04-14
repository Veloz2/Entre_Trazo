package com.entretrazo.entretrazo.controller;

import com.entretrazo.entretrazo.model.Solicitud;
import com.entretrazo.entretrazo.repository.SolicitudRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SolicitudRepository repo;

    // Mostrar login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Procesar login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, Model model) {
        if (username.equals("admin") && password.equals("admin123")) {
            session.setAttribute("admin", true);
            return "redirect:/admin/panel";
        }
        model.addAttribute("error", true);
        return "login";
    }

    // Panel principal
    @GetMapping("/panel")
    public String panel(HttpSession session, Model model) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }
        model.addAttribute("solicitudes", repo.findAll());
        return "panel";
    }

    // Actualizar estado
    @PostMapping("/solicitudes/{id}/estado")
    public String actualizarEstado(@PathVariable Long id,
                                   @RequestParam String estado,
                                   HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }
        Solicitud s = repo.findById(id).orElseThrow();
        s.setEstado(estado);
        repo.save(s);
        return "redirect:/admin/panel";
    }

    // Cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}