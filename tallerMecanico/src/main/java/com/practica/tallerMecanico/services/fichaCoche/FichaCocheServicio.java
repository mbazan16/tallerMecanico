package com.practica.tallerMecanico.services.fichaCoche;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.ClienteRepository;
import com.practica.tallerMecanico.repositories.CocheRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FichaCocheServicio implements IFichaCoche {



	@Autowired
	private CocheRepository cocheRepository; 
	@Autowired
	private ClienteRepository clienteRepository; 
	@Autowired
	private TrabajoRepository trabajoRepository; 


	public List<Coche> getAllCoches() {
		log.info("[getAllCoches]");

		List<Coche> coches = cocheRepository.findAll();

		coches.forEach(c -> log.debug(c.toString()));

		
		return coches;
	}


	public Coche getCocheById(Long id){
		
		
		
		return cocheRepository.findById(id).get();
	}

	public List<Cliente> getClientesByCocheId(Integer id){		


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
