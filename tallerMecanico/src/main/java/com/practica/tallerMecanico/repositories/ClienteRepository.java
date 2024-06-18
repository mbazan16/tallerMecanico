package com.practica.tallerMecanico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
