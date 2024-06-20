package com.practica.tallerMecanico.controllers.piezas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PiezasController {
	
	@GetMapping("/piezas")
	public String entrada() {
		log.info("Entrada Piezas");
		
        return "piezas";
    }
}
