package com.practica.tallerMecanico.services.dashboard;

import java.time.LocalDate;
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
	public List<Trabajo> getTrabajosPendientes() {
		return null;
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
	//SERVICIO #5: Listado de Trabajos en Ejecución
	//SERVICIO #6: Terminar Trabajo, dar el trabajo por concluido. En este punto se realizará el cálculo del coste total del trabajo, insertándolo en la base de datos.



}
