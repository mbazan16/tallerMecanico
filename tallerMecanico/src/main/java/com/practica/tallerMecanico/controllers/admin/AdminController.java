package com.practica.tallerMecanico.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practica.tallerMecanico.entities.Entrega;
import com.practica.tallerMecanico.entities.Reserva;

@Controller
public class AdminController {

	@GetMapping("/admin")
    
    public String mostrarPaginaAdministracion(Model model) {
    	
        List<Reserva> reservaPendiente = getReservaPendientes();
        
        List<Entrega> entregaPendiente = getEntregaPendientes() ;

        model.addAttribute("reservaPendiente", reservaPendiente);
        model.addAttribute("entregaPendiente", entregaPendiente);

        return "admin";
    }
	
	public List<Reserva> getReservaPendientes() 
	{
		List<Reserva> reservas = new ArrayList<>();
		return reservas;
	}
	
	public List<Entrega> getEntregaPendientes() 
	{
		List<Entrega> entregas = new ArrayList<>();
		return entregas;
	}
	
	
	
}