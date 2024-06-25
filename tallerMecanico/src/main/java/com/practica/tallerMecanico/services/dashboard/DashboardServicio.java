package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.MessageError;
import com.practica.tallerMecanico.services.common.ServiceException;

@Service
public class DashboardServicio implements IDashboard {

    private static final Logger log = LoggerFactory.getLogger(DashboardServicio.class);

    @Autowired
    private TrabajoRepository trabajoRepository;
    
    //SERVICIO 1: Obtener un listado de trabajos programados para hoy

    public List<Trabajo> getTrabajosHoy(LocalDate fechaHoy) throws ServiceException {
        log.info("[Listado Trabajos Hoy]");
        try {
            if (fechaHoy == null) {
                throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
            }
            return trabajoRepository.findAllByFProgramacion(fechaHoy);
        } catch (ServiceException se) {
            log.error("ServiceException: {}", se.getMessage());
            throw se;
        } catch (Exception e) {
            log.error("Error al obtener trabajos programados para hoy", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }
    
    //SERVICIO 2: Obtener un listado de trabajos pendientes


    public List<Trabajo> getTrabajosPendientes() throws ServiceException {
        log.info("[getTrabajosPendientes]");
        try {
            return trabajoRepository.findAllByEstado(EstadoTrabajo.PENDIENTE);
        } catch (Exception e) {
            log.error("Error al obtener trabajos pendientes", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }
    
    //SERVICIO 3: Obtener un listado de trabajos en ejecución

    
    public List<Trabajo> getTrabajosEjecucion() throws ServiceException {
        log.info("[getTrabajosEjecucion]");
        try {
            return trabajoRepository.findAllByEstado(EstadoTrabajo.EJECUCION);
        } catch (Exception e) {
            log.error("Error al obtener trabajos en ejecución", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }
    
    //SERVICIO 4: Lanzar una lista de trabajos desde un buscador según el número de matrícula del coche

    public List<Trabajo> buscador(String matricula) throws ServiceException {
        log.info("[buscador]");
        log.debug("[matricula: {}]", matricula);
        try {
            if (matricula == null || matricula.trim().isEmpty()) {
                throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
            }
            return trabajoRepository.findAllByMatricula(matricula);
        } catch (ServiceException ae) {
            log.error("ServiceException: {}", ae.getMessage());
            throw ae;
        } catch (Exception e) {
            log.error("Error al buscar trabajos por matrícula", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }
    
    //SERVICIO 5: cambiar el estado del trabajo programado para hoy cuando se inicie, dandole clic al botón "iniciar"
    // cambia a en ejecución


    public void iniciarTrabajo(Integer id) throws ServiceException {
        log.info("[iniciarTrabajo] Id: {}", id);
        try {
            if (id == null) {
                throw new ServiceException(MessageError.EC_EXCEPCION_NO_ID);
            }else {
        	Trabajo trabajo = trabajoRepository.findById(id).get();
        	trabajo.setEstado(EstadoTrabajo.EJECUCION);
        	trabajo.setFechaInicio(LocalDateTime.now());
        	trabajoRepository.save(trabajo);}
        } catch (ServiceException se) {
            log.error("ServiceException: {}", se.getMessage());
            throw se;
        } catch (Exception e) {
            log.error("Error al iniciar trabajo", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }
    
    //SERVICIO 5: cambiar el estado del trabajo en ejecución cuando se termine, dandole clic al botón "terminar"
    // cambia a terminado

    public void terminarTrabajo(Integer id) throws ServiceException {
        log.info("[terminarTrabajo] Id: {}", id);
        try {
            if (id == null) {
                throw new ServiceException(MessageError.EC_EXCEPCION_NO_ID);
            }else {
            	Trabajo trabajo = trabajoRepository.findById(id).get();
            	trabajo.setEstado(EstadoTrabajo.TERMINADO);
            	trabajo.setFechaFin(LocalDateTime.now());
            	trabajoRepository.save(trabajo);}
        } catch (ServiceException se) {
            log.error("ServiceException: {}", se.getMessage());
            throw se;
        } catch (Exception e) {
            log.error("Error al terminar trabajo", e);
            throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
        }
    }

}

