package com.practica.tallerMecanico.controllers.fichaCoche;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.fichaCoche.FichaCocheServicio;

@Controller
public class FichaCocheController {

	@Autowired 
	private FichaCocheServicio fichaCocheServicio;
	
	
	@GetMapping("/fichaCoche/{id}")
	public String visualizarFichaCoche(@PathVariable(name="id") Long id, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(required= false) String tipoCoche, @RequestParam(required= false) LocalDate fecha) {
		
		Coche coche= fichaCocheServicio.getCocheById(id);
		
		List<Cliente> clientes = fichaCocheServicio.getClientesByCocheId(id);
		
		List<Trabajo> trabajos = fichaCocheServicio.getTrabajoByTipoTrabajo(tipoCoche, fecha);
		
		
		model.addAttribute("coche",coche);
		
		model.addAttribute("clientes",clientes);
		
		model.addAttribute("trabajos",trabajos);
		
		return "fichaCoche";
	}
	
	
	
	
	
}
