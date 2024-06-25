package com.practica.tallerMecanico.services.fichaTrabajo;

import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.services.fichaTrabajo.exception.FichaTrabajoException;

public interface IFichaTrabajo {
	
	public Trabajo getTrabajoById(Integer id)throws FichaTrabajoException;
}
