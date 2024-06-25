package com.practica.tallerMecanico.controllers.dashboard;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = {"/dashboard"})
public class DashboardController {

    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private DashboardServicio dashboardServicio;

    @GetMapping
    public String showDashboard(Model model) throws ServiceException {
        log.info("Iniciando método showDashboard");

        try {
            log.debug("Obteniendo trabajos para hoy");
            List<Trabajo> trabajosHoy = dashboardServicio.getTrabajosHoy(LocalDate.now());
            model.addAttribute("trabajosHoy", trabajosHoy);

            log.debug("Obteniendo trabajos en ejecución");
            List<Trabajo> ejecucion = dashboardServicio.getTrabajosEjecucion();
            model.addAttribute("ejecucion", ejecucion);

            log.debug("Obteniendo trabajos pendientes");
            List<Trabajo> pendientes = dashboardServicio.getTrabajosPendientes();
            model.addAttribute("pendientes", pendientes);

            String matricula = "ABC123"; // O la lógica para obtener la matrícula
            log.debug("Obteniendo trabajos por matrícula: {}", matricula);
            List<Trabajo> buscadorXMatricula = dashboardServicio.buscador(matricula);
            model.addAttribute("buscadorXMatricula", buscadorXMatricula);

            log.info("Método showDashboard completado exitosamente");
            return "dashboard";
        } catch (ServiceException e) {
            log.error("Error en el método showDashboard", e);
            throw e;
        }
    }

    @GetMapping("/i/{id}")
    public String iniciarTrabajo(@PathVariable("id") Integer id) throws ServiceException {
        log.info("Iniciando método iniciarTrabajo para el trabajo con id: {}", id);

        try {
            dashboardServicio.iniciarTrabajo(id);
            log.info("Trabajo con id: {} iniciado exitosamente", id);
            return "redirect:/dashboard";
        } catch (ServiceException e) {
            log.error("Error al iniciar trabajo con id: {}", id, e);
            throw e;
        }
    }

    @GetMapping("/t/{id}")
    public String terminarTrabajo(@PathVariable("id") Integer id) throws ServiceException {
        log.info("Iniciando método terminarTrabajo para el trabajo con id: {}", id);

        try {
            dashboardServicio.terminarTrabajo(id);
            log.info("Trabajo con id: {} terminado exitosamente", id);
            return "redirect:/dashboard";
        } catch (ServiceException e) {
            log.error("Error al terminar trabajo con id: {}", id, e);
            throw e;
        }
    }
}



