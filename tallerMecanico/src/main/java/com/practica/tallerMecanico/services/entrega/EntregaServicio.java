package com.practica.tallerMecanico.services.entrega;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

=======
>>>>>>> refs/heads/reservas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Entrega;
=======
>>>>>>> refs/heads/reservas
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.EntregaRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaServicio implements IEntregaServicio {
	
	@Autowired
	TrabajoRepository trabajoRepository;
	
	@Autowired
	EntregaRepository entregaRepository;
	
	
	public Trabajo getTrabajo(Integer id) {
		log.info("[getTrabajo]");
		log.debug("[Trabajo ID: "+id+"]");
<<<<<<< HEAD
		return trabajoRepository.findById(id)
                .orElseThrow(() -> new TrabajoNotFoundException("Trabajo no encontrado con ID: " + id));
=======
		return repository.findById(id).get();
>>>>>>> refs/heads/reservas
	}
<<<<<<< HEAD
	
	public void procesarFecha(String fecha, String hora ,int id) throws ServiceException {
        log.info("[procesarFecha]");
        log.debug("[Fecha: " + fecha + "]");
        
       

        try {
            LocalDate fechaLocal = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalTime horaLocal = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime fechaProcesada = fechaLocal.atTime(horaLocal);
            log.info("Fecha procesada correctamente: " + fechaProcesada);
            insertarEntrega(fechaProcesada, id);
        } catch (DateTimeParseException e) {
            throw new ServiceException("Formato de fecha inválido: " + fecha);
        }
    }
	
	@Transactional
    public void insertarEntrega(LocalDateTime fechaProcesada, int id) throws ServiceException {
		Trabajo trabajo = getTrabajo(id);
        trabajo.setFechaRecogida(fechaProcesada);
        log.info(trabajo.toString());
        trabajoRepository.save(trabajo);
        
        Entrega entrega = new Entrega();
        entrega.setFechaRecogida(fechaProcesada);
        entrega.setCoche(trabajo.getCoche());
        entrega.setCliente(trabajo.getCliente());
        entrega.setTrabajo(trabajo);
        log.info(entrega.toString());
        entregaRepository.save(entrega);
        
        log.info("Actualizada correctamente en la base de datos.");
    }



	
=======
>>>>>>> refs/heads/reservas
}
