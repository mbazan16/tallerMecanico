package com.practica.tallerMecanico.controllers.dashboard;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.dashboard.DashboardServicio;


@Controller
@RequestMapping(value={"/dashboard"})
public class DashboardController {

	    @Autowired
	    private DashboardServicio dashboardServicio;	    
	    
	    //Servicio trabajos para hoy
	    @GetMapping
	    public String tablaTrabajosHoy(Model model) throws ServiceException {
	        List<Trabajo> trabajosHoy = dashboardServicio.getTrabajosHoy(LocalDate.now());
	        model.addAttribute("trabajosHoy", trabajosHoy);	
	        List<Trabajo> trabajosPendientes = dashboardServicio.getTrabajosPendientes();
	        model.addAttribute("trabajosPendientes", trabajosPendientes);	
	        List<Trabajo> trabajosEjecucion = dashboardServicio.getTrabajosEjecucion();
	        model.addAttribute("trabajosEjecucion", trabajosEjecucion);	
			return "dashboard";		
	    }
	   
	    
	}


