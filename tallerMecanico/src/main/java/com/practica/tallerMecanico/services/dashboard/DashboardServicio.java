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
public class DashboardServicio implements IDashboard{
	//Trazas
		public static final Logger log = LoggerFactory.getLogger(Trabajo.class);
	@Autowired
	private TrabajoRepository trabajoRepository;
	
	
	//SERVICIO #1: Trabajo Programado hoy: obtener una lista de trabajos programados para hoy(fecha)

	public List<Trabajo> getTrabajosHoy(LocalDate fechaHoy) throws ServiceException{
		log.info("[Listado Trabajos Hoy]");
		List<Trabajo> trabajosHoy = new ArrayList<Trabajo>();
		try{
			//Validacion de parametros
			if(fechaHoy == null)
				throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
			//La lógica de negocio que devuelve una lista de trabajos segun la programacion
			trabajosHoy=trabajoRepository.findAllByFProgramacion(LocalDate.now());
		}catch (Exception e) {
			log.error("Exception", e);
		}
			return trabajosHoy;
		}
	
  
	//SERVICIO #2: Trabajos pendientes de empezar
	public List<Trabajo> getTrabajosPendientes() throws ServiceException{
		log.info("[getTrabajosPendientes]");		
		List<Trabajo> trabajosPendientes = new ArrayList<Trabajo>();
		try {
			//La propia logica de negocio
			trabajosPendientes= trabajoRepository.findAllByEstado(EstadoTrabajo.PENDIENTE);
		}catch (Exception e) {
			log.error("Exception", e);
		}
		return trabajosPendientes;
    }
	
	//SERVICIO #3:Buscador por matrícula del coche del cliente en trabajos programados para hoy
	public List<Trabajo> buscador(String matricula)throws ServiceException{
		log.info("[buscador]");
		log.debug("[matricula:"+matricula+"]");
		List<Trabajo> trabajosXmatricula = new ArrayList<Trabajo>();
		try {
			//Validacion de parametros
			if(matricula == null || matricula.trim().isEmpty())
				throw new ServiceException(MessageError.EC_EXCEPCION_GENERAL);
			//La propia logica de negocio
			trabajosXmatricula= trabajoRepository.findAllByMatricula(matricula);
		}catch(ServiceException ae) {
			log.error("ServiceException", ae);
			throw ae;
		} catch (Exception e) {
			log.error("Exception", e);
		}
		return trabajosXmatricula;

	}
	//SERVICIO #4: Iniciar Trabajo mediante el botón Iniciar para trabajos programados, para hoy o no.
	public void cambiarEstadoTrabajo(Integer id){
		Trabajo trabajo = trabajoRepository.findById(id).get();
		if(id!=null) {
		Trabajo trabajoEstado = new Trabajo();
		trabajoEstado .setEstado(EstadoTrabajo.EJECUCION);
		trabajoEstado .setFechaInicio(LocalDateTime.now());
		trabajoRepository.save(trabajo);
		}
	}
	
	//SERVICIO #5: Listado de Trabajos en Ejecución
	public List<Trabajo> getTrabajosEjecucion() throws ServiceException{
		log.info("[getTrabajosEjecucion]");		
		List<Trabajo> trabajosEjecucion = new ArrayList<Trabajo>();
		try {
			//La propia logica de negocio
			trabajosEjecucion= trabajoRepository.findAllByEstado(EstadoTrabajo.EJECUCION);
		}catch (Exception e) {
			log.error("Exception", e);
		}
		return trabajosEjecucion;
    }
	//SERVICIO #6: Terminar Trabajo, dar el trabajo por concluido. En este punto se realizará el cálculo del coste total del trabajo, insertándolo en la base de datos.
	public void cambiarTrabajoATerminado(Integer id) throws ServiceException{
		Trabajo trabajo = trabajoRepository.findById(id).get();
		if(id!=null) {
		Trabajo trabajoTerminado = new Trabajo();
		trabajoTerminado.setEstado(EstadoTrabajo.TERMINADO);
		trabajoTerminado.setFechaFin(LocalDateTime.now());
		trabajoRepository.save(trabajo);
		} else {
			throw new ServiceException(MessageError.EC_EXCEPCION_NO_ID);
		}
	}


}
