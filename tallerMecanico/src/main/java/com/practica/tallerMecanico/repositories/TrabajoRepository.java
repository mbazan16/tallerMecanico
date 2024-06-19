package com.practica.tallerMecanico.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    
    List<Trabajo> findAllByFechaInicio(LocalDate fechaInicio);
    List<Trabajo> findAllByFechaEntregaBefore(LocalDate fechaHoy);
    List<Trabajo> findAllByEstado(String estado);
    List<Trabajo> findAllByFechaInicioOrderByFechaInicioAsc();
    List<Trabajo> findAllByFechaProgramacion(LocalDate fechaProgramacion);
    List<Trabajo> findAllByEstadoAndMecanico(String estado, String mecanico);
}


