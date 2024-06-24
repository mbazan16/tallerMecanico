package com.practica.tallerMecanico.controllers.piezas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.tallerMecanico.entities.Pieza;
import com.practica.tallerMecanico.services.pieza.PiezasServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PiezasController {
	
	@Autowired
	private PiezasServicio servicio;
	
	
	
	@GetMapping("/piezas")
	public String listarPiezas(Model model,@RequestParam(required = false) String codigo,@RequestParam(required = false) String nombre) {
        log.info("listarPiezas");

        List<Pieza> listaPiezas = servicio.listarPiezas(codigo,nombre);
        
        model.addAttribute("piezas", listaPiezas); 
        
        return "piezas"; 
    }
}
