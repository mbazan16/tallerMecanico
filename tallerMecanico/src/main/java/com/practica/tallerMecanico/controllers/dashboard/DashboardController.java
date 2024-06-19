package com.practica.tallerMecanico.controllers.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.dashboard.DashboardServicio;

@Controller
public class DashboardController {

	    @Autowired
	    private DashboardServicio dashboardServicio;	    
	    
	    //Servicio trabajos para hoy
	    @GetMapping("/pending")
	    public List<Trabajo> getTrabajosHoy() {
	        return dashboardServicio.getTrabajosHoy();
	    }
	}


