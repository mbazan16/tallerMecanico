package com.practica.tallerMecanico.controllers.piezas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;

import com.practica.tallerMecanico.entities.Pieza;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.pieza.PiezasServicio;
=======
>>>>>>> refs/heads/reservas

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PiezasController {
	
	@GetMapping("/piezas")
<<<<<<< HEAD
	public String listarPiezas(Model model,@RequestParam(required = false) String codigo,@RequestParam(required = false) String nombre,
								@RequestParam(required = false) String matricula) {
        log.info("listarPiezas");

        List<Pieza> listaPiezas = servicio.listarPiezas(codigo,nombre);
        List<Trabajo> trabajosEnEjecucion = servicio.listarTrabajosEnEjecucion(matricula);
        
        model.addAttribute("piezas", listaPiezas); 
        model.addAttribute("trabajosEnEjecucion", trabajosEnEjecucion);
        
        
        
        return "piezas"; 
=======
	public String entrada() {
		log.info("Entrada Piezas");
		
        return "piezas";
>>>>>>> refs/heads/reservas
    }
}
