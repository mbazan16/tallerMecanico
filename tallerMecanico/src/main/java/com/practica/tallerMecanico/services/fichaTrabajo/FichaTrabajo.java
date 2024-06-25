package com.practica.tallerMecanico.services.fichaTrabajo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.TrabajoRepository;
import com.practica.tallerMecanico.services.common.ErrorCode;
import com.practica.tallerMecanico.services.fichaTrabajo.exception.FichaTrabajoException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FichaTrabajo implements IFichaTrabajo {
	
    @Autowired
    TrabajoRepository repositorio;

	@Override
	public Trabajo getTrabajoById(Integer id)throws FichaTrabajoException {
		log.info("[getTrabajoById]");
		log.debug("id:"+id);
		
		Trabajo trabajo=null;
		try {
			
			Optional<Trabajo> trabajoAux = repositorio.findById(id);
			if(!trabajoAux.isPresent()) throw new FichaTrabajoException(ErrorCode.EC_TRABAJO_NOT_FOUND);
			log.debug("trabajo:"+trabajo.toString());
			trabajo=trabajoAux.get();
		}catch(FichaTrabajoException fte) {
			log.error("FichaTrabajoException",fte);
			throw fte;
			
		}catch(Exception e) {
			log.error("Exception",e);
			throw new FichaTrabajoException(ErrorCode.EC_EXCEPCION_GENERAL);
		}
		return trabajo;
	}

}
