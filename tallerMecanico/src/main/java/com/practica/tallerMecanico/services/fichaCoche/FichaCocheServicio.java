package com.practica.tallerMecanico.services.fichaCoche;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.repositories.ClienteRepository;
import com.practica.tallerMecanico.repositories.CocheRepository;
import com.practica.tallerMecanico.services.common.FichaCocheException;

public class FichaCocheServicio implements IFichaCoche {

	Logger log = LoggerFactory.getLogger(FichaCocheServicio.class);

	@Autowired
	private CocheRepository cocheRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository;


	//GET COCHE BY ID
	public Coche getCocheById(Long id){ //Añadir Excepciones
		
		return cocheRepository.findById(id)
				.orElseThrow(() -> new FichaCocheException("Coche no encontrado con ID: " + id));
	}

	//GET CLIENTE BY COCHE ID
	public List<Cliente> getClientesByCocheId(Long id){ //Añadir excepciones y test

	List<Cliente> clientes = clienteRepository.findAllByCocheId(id);
	 
		return clientes; 
	}
	

	// Historico Trabajadores

}
