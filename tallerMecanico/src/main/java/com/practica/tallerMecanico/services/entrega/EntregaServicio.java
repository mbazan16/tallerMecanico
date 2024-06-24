package com.practica.tallerMecanico.services.entrega;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void procesarFecha(String fecha) throws ServiceException {
        log.info("[procesarFecha]");
        log.debug("[Fecha: " + fecha + "]");

        // Define el formato de fecha y hora esperado
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        try {
            // Comprueba que la fecha se recibe en el formato correcto
            LocalDateTime fechaProcesada = LocalDateTime.parse(fecha, formatoFecha);
            log.info("Fecha procesada correctamente: " + fechaProcesada);
        } catch (DateTimeParseException e) {
            throw new ServiceException("Formato de fecha inválido: " + fecha);
        }
    }
}
