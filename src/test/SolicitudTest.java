package com.entretrazo.entretrazo;

import com.entretrazo.entretrazo.model.Solicitud;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolicitudTest {

    @Test
    void estadoInicialEsPendiente() {
        Solicitud s = new Solicitud();
        assertEquals("pendiente", s.getEstado());
    }

    @Test
    void asignarNombreCorrectamente() {
        Solicitud s = new Solicitud();
        s.setNombre("Juan Pérez");
        assertEquals("Juan Pérez", s.getNombre());
    }

    @Test
    void asignarTipoCorrectamente() {
        Solicitud s = new Solicitud();
        s.setTipo("cotizacion");
        assertEquals("cotizacion", s.getTipo());
    }
}