package com.entretrazo.entretrazo.controller;

import com.entretrazo.entretrazo.model.*;
import com.entretrazo.entretrazo.repository.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SolicitudController {

    @Autowired
    private SolicitudRepository repo;

    // POST /api/solicitudes — recibe el formulario del cliente
    @PostMapping("/solicitudes")
    public ResponseEntity<String> guardar(@Valid @RequestBody Solicitud solicitud) {
        repo.save(solicitud);
        return ResponseEntity.ok("Solicitud recibida correctamente.");
    }
}