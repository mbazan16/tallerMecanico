package com.practica.tallerMecanico.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
    
<<<<<<< HEAD
    List<Trabajo> findAllByFechaInicio(LocalDate fechaInicio); //Busqueda por fecha de inicio listo
    List<Trabajo> findAllByEstado(Integer estado); // Busqueda por estado Listo
    List<Trabajo> findAllByFechaProgramacion(LocalDate fechaProgramacion); // Busqueda por fecha de fecha de programacion Listo
    
    
    
    
    List<Trabajo> findAllByFechaInicioAfter(LocalDate fechaHoy);
    List<Trabajo> findAllByFechaEntregaBefore(LocalDate fechaHoy); 
    List<Trabajo> findAllByEstadoAndMecanico(Number estado, String mecanico);
    List<Trabajo> findAllByCocheMatricula(String matricula);
    List<Trabajo> findAllByClienteTelefono(String telefono);
    
=======
    List<Trabajo> findAllByFechaInicio(LocalDate fechaInicio);
    List<Trabajo> findAllByFechaEntregaBefore(LocalDate fechaHoy);
>>>>>>> branch 'master' of https://github.com/mbazan16/tallerMecanico.git
}

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://github.com/mbazan16/tallerMecanico.git
