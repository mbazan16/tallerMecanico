package com.practica.tallerMecanico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PiezaRepository extends JpaRepository<Pieza,Integer> {
	
 List<Pieza>findAllById();
}
