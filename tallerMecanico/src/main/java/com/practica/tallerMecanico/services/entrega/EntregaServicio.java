package com.practica.tallerMecanico.services.entrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaServicio implements IEntregaServicio {
	
	@Autowired
	TrabajoRepository repository;
	
	public Trabajo getTrabajo(Integer id) {
		log.info("[getTrabajo]");
		log.debug("[Trabajo ID: "+id+"]");
		return repository.findById(id).get();
	}
}
