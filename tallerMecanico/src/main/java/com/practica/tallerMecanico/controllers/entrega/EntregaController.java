package com.practica.tallerMecanico.controllers.entrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.services.entrega.IEntregaServicio;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/entrega")
@Slf4j
public class EntregaController {
	
	@Autowired
	IEntregaServicio servicio;
	
	

}
