package com.practica.tallerMecanico.services.fichaCoche;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.ClienteRepository;
import com.practica.tallerMecanico.repositories.CocheRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.FichaCocheException;

public class FichaCocheServicio implements IFichaCoche {

	Logger log = LoggerFactory.getLogger(FichaCocheServicio.class);

	@Autowired
	private CocheRepository cocheRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TrabajoRepository trabajoRepository;
	
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

	
	
	//MÉTODOS TRABAJOS
	
	public List<Trabajo> getTrabajoByTipoTrabajo(String tipo, LocalDate fecha){
		
		List<Trabajo> trabajos;
		
		if(tipo != null && !tipo.trim().isEmpty())
			trabajos= trabajoRepository.findAllByTipo(tipo);
		else if(fecha!=null)
			trabajos= trabajoRepository.findAllByFechaInicio(fecha);
		else
			trabajos= trabajoRepository.findAll();
		return trabajos;
	}
	
	
	// Historico Trabajadores

}
