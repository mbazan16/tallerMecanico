package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.dto.TrabajoLPH;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

@Service
public class DashboardServicio implements IDashboard{
	//Trazas
		public static final Logger log = LoggerFactory.getLogger(Trabajo.class);
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	
	//Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)

	public List<TrabajoLPH> getTrabajosHoy(Long idMecanico) {
		//metodo para obtener una lista de trabajos, la filtramos por fecha de inicio y luego devuelve los trabajos
		//si esa fecha de inicio coincide con la fecha de hoy
		
		try{
			List<Trabajo> trabajos=trabajoRepository.findAllByFechaProgramacion(LocalDate.now(), idMecanico);	
			
			List<TrabajoLPH> trabajosLPH = trabajos.stream().map(this::map).collect(Collectors.toList());
			}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return trabajosLPH;		

		//Traza
		log.info("Obteniendo trabajos de hoy");
		//se devuelve los trabajos filtrados que su fecha de programacion coincide con la fecha de hoy
	}
	
  
	//Trabajos pendientes de empezar
	public List<Trabajo> getTrabajosPendientes() {
		List<Trabajo> trabajos= trabajoRepository.findAllByFechaProgramacion(LocalDate.now(), idMecanico);
		return trabajos;
    }
	
	//Buscador por matrícula del coche o teléfono del cliente en trabajos programados para hoy
	public List<Trabajo> buscador(){
		log.info("[buscador]");
		log.debug("[matricula:"+matricula"]");
		try {
			//Validacion de parametros
			if(matricula == null || matricula.trim().isEmpty())
				throw new Exception();
			//La propia logica de negocio
			List<Trabajo> matriculas = trabajoRepository.findAllByCocheMatricula(String matricula);

		}catch(AdminException ae) {
			log.error("AdminException", ae);
			throw ae;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new AdminException();
		}
		return matriculas;

	}
	
	//metodo para mapear dto
	private  TrabajoLPH map(Trabajo trabajo) {
		TrabajoLPH trabajoLPH = new TrabajoLPH();
		return trabajoLPH;
	}
}
