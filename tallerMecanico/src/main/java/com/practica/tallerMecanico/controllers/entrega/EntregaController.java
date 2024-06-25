package com.practica.tallerMecanico.controllers.entrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.entrega.IEntregaServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/entrega")
@Slf4j
public class EntregaController {
	
	@Autowired
	IEntregaServicio servicio;
	
    public String mostrarTrabajo(Integer id, Model model) throws ServiceException {
    	log.info("mostrarTrabajo");
    	log.debug("id: "+id);
    	Trabajo trabajo =servicio.getTrabajo(id);
        model.addAttribute("trabajo", trabajo);
        
        return "entrega";
    }

}
