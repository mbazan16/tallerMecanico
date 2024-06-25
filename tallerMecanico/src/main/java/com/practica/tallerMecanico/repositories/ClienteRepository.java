package com.practica.tallerMecanico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practica.tallerMecanico.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	//Lista de clientes por Coche
	@Query("SELECT c FROM Cliente c JOIN c.coches c WHERE c.id = :cocheId")
	List<Cliente> findAllByCocheId(Integer id);
	
	//Cliente por teléfono
	@Query("SELECT c FROM Cliente c  WHERE c.telefono = :telefono")
	Cliente findByTelefono(String telefono);
}
