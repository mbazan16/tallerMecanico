package com.practica.tallerMecanico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//Lista de clientes por Coche
	
	
	//Cliente por teléfono
}
