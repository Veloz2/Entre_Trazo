package com.entretrazo.entretrazo.repository;

import com.entretrazo.entretrazo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}