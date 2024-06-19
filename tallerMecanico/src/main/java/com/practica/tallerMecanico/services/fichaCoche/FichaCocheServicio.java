package com.practica.tallerMecanico.services.fichaCoche;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.repositories.CocheRepository;

public class FichaCocheServicio implements IFichaCoche {

	Logger log = LoggerFactory.getLogger(FichaCocheServicio.class);

	@Autowired
	private CocheRepository cocheRepository; 

	public List<Coche> getAllCoches() {
		log.info("[getAllCoches]");

		List<Coche> coches = cocheRepository.findAll();

		coches.forEach(c -> log.debug(c.toString()));
		
		return coches;
	}

	public Optional<Coche> getCocheById(Integer id){
		
		
		
		return cocheRepository.findById(id);
	}

	public List<Cliente> getClientesByCocheId(Integer id){
		
		return null;
	}

	// Historico Trabajadores

}
