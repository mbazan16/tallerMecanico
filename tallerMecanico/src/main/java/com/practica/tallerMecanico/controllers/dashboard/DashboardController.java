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
	    @GetMapping("/trabajosHoy")
	    public String tablaTrabajosHoy(Model model) throws ServiceException {
	        List<Trabajo> trabajosHoy = dashboardServicio.getTrabajosHoy(LocalDate.now());
	        model.addAttribute("trabajosHoy", trabajosHoy);	
			return "dashboard";		
	    }
	    //Servicio trabajos pendientes
	    @GetMapping("/trabajosPendientes")
	    public String tablaTrabajosPendientes(Model model) throws ServiceException {
	        List<Trabajo> trabajosPendientes = dashboardServicio.getTrabajosPendientes();
	        model.addAttribute("trabajosPendientes", trabajosPendientes);	
			return "dashboard";		
	    }
	    //Servicio trabajos ejecucion
	    @GetMapping("/trabajosEjecucion")
	    public String tablaTrabajosEjecucion(Model model) throws ServiceException {
	        List<Trabajo> trabajosEjecucion = dashboardServicio.getTrabajosEjecucion();
	        model.addAttribute("trabajosEjecucion", trabajosEjecucion);	
			return "dashboard";		
	    }
		//SERVICIO #5: Listado de Trabajos en Ejecución
	    
	}


