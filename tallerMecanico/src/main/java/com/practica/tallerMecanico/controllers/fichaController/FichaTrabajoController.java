package com.practica.tallerMecanico.controllers.fichaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.fichaTrabajo.IFichaTrabajo;
import com.practica.tallerMecanico.services.fichaTrabajo.exception.FichaTrabajoException;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ft")
@Slf4j
public class FichaTrabajoController {
	
	@Autowired
	IFichaTrabajo servicio;
	
	
	@GetMapping
	public String ver(Model Model, Integer id) throws FichaTrabajoException {
		log.info("[ver]");
		log.debug("id:"+id);
		
		Trabajo trabajo = servicio.getTrabajoById(id);
		return "fichaTrabajo";
	}

}
