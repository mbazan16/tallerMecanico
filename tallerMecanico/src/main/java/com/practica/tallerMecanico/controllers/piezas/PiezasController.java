package com.practica.tallerMecanico.controllers.piezas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PiezasController {
	Logger log = LoggerFactory.getLogger(PiezasController.class);
	
	@GetMapping("/piezas")
	public String entrada() {
		log.info("Entrada Piezas");
		
        return "piezas";
    }
	
	@GetMapping("/agregarpiezas")
	public String agregapiezas() {
		log.info("Entrada Piezas");
		
        return "agregarpiezas";
    }
}
