package com.practica.tallerMecanico.services.entrega;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ServiceException;
import com.practica.tallerMecanico.services.common.TrabajoNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaServicio implements IEntregaServicio {
	
	@Autowired
	TrabajoRepository repository;
	
	public Trabajo getTrabajo(Integer id) throws ServiceException {
		log.info("[getTrabajo]");
		log.debug("[Trabajo ID: "+id+"]");
		return repository.findById(id)
                .orElseThrow(() -> new TrabajoNotFoundException("Trabajo no encontrado con ID: " + id));
	}
	
	public void procesarFecha(String fecha, int id) throws ServiceException {
        log.info("[procesarFecha]");
        log.debug("[Fecha: " + fecha + "]");

        // Define el formato de fecha y hora
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        try {
            // Comprueba que la fecha se recibe en el formato correcto
            LocalDateTime fechaProcesada = LocalDateTime.parse(fecha, formatoFecha);
            log.info("Fecha procesada correctamente: " + fechaProcesada);
            insertarFecha(fechaProcesada, id);
        } catch (DateTimeParseException e) {
            throw new ServiceException("Formato de fecha inválido: " + fecha);
        }
    }
	
	@Transactional
    public void insertarFecha(LocalDateTime fechaProcesada, int id) throws ServiceException {
		Trabajo trabajo = getTrabajo(id);
        trabajo.setFechaEntrega(fechaProcesada);
        repository.save(trabajo);
        
        log.info("Fecha actualizada correctamente en la base de datos.");
    }

	
}
