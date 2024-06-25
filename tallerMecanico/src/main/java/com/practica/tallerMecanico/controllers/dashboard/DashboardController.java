package com.practica.tallerMecanico.controllers.dashboard;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.dashboard.DashboardServicio;


@Controller
@RequestMapping(value={"/dashboard"})
public class DashboardController {

	    @Autowired
	    private DashboardServicio dashboardServicio;
	    
	    String matricula = new Trabajo().getCoche().getMatricula();
	    
	    
	    //Servicio trabajos para hoy
	    @GetMapping
	    public String showDashboard(Model model) throws ServiceException {
	    	//Lista trabajos hoy
	        List<Trabajo> trabajosHoy = dashboardServicio.getTrabajosHoy(LocalDate.now());
	        model.addAttribute("trabajosHoy", trabajosHoy);	
	        //Lista trabajos en ejecucion
	        List<Trabajo> ejecucion = dashboardServicio.getTrabajosEjecucion();
	        model.addAttribute("ejecucion", ejecucion);
	        //Lista trabajos pendientes
	        List<Trabajo> pendientes = dashboardServicio.getTrabajosPendientes();
	        model.addAttribute("pendientes", pendientes);	
	        //Buscador
	        List<Trabajo> buscadorXMatricula = dashboardServicio.buscador(matricula);
	        model.addAttribute("buscadorXMatricula", buscadorXMatricula );
	        //Boton iniciar
	        //Boton Terminar

			return "dashboard";	        		
	    }
	    
	    @GetMapping("/i/{id}")
	    public String iniciarTrabajo(Model model,@PathVariable("id") Integer id) throws ServiceException {
	    	
	    	dashboardServicio.iniciarTrabajo(id);
	    	
	      return "redirect:/dashboard";
	    }
	    @GetMapping("/i/{id}")
	    public String terminarTrabajo(Model model,@PathVariable("id") Integer id) throws ServiceException {
	    	
	    	dashboardServicio.terminarTrabajo(id);
	    	
	      return "redirect:/dashboard";
	    }
	}
	    
	    


