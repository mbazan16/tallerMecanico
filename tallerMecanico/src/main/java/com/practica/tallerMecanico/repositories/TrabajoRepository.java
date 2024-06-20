package com.practica.tallerMecanico.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practica.tallerMecanico.entities.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    
    List<Trabajo> findAllByFechaInicio(LocalDate fechaInicio);
    List<Trabajo> findAllByFechaEntregaBefore(LocalDate fechaHoy);
}

