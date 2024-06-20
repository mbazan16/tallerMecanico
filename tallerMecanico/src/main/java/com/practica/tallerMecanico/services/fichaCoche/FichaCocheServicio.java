package com.practica.tallerMecanico.services.fichaCoche;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.repositories.ClienteRepository;
import com.practica.tallerMecanico.repositories.CocheRepository;

public class FichaCocheServicio implements IFichaCoche {

	Logger log = LoggerFactory.getLogger(FichaCocheServicio.class);

	@Autowired
	private CocheRepository cocheRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository;


	//GET COCHE BY ID
	public Optional<Coche> getCocheById(Long id){
		
		return cocheRepository.findById(id);
	}

//	//GET CLIENTE BY COCHE ID
//	public List<Cliente> getClientesByCocheId(Long id){
//		
//	Optional<Coche> coche =	cocheRepository.findById(id);
//
////	Cliente cliente = clienteRepository.findByCoche(coche);
//	
//		return null; //cliente
//	}

	// Historico Trabajadores

}
