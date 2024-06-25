package com.practica.tallerMecanico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.tallerMecanico.entities.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long>{

	
	//Coche por matricula
		@Query("SELECT c FROM Coche c WHERE c.matricula = :matricula")
		Coche findByMatricula(String matricula);


	
		
}
