package com.practica.tallerMecanico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.PKPiezasTrabajo;
import com.practica.tallerMecanico.entities.PiezasTrabajo;

public interface PiezasTrabajoRepository extends JpaRepository<PiezasTrabajo, PKPiezasTrabajo>{

}
