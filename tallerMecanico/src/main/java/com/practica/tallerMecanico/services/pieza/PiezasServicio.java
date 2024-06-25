package com.practica.tallerMecanico.services.pieza;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Pieza;
import com.practica.tallerMecanico.entities.PiezasTrabajo;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.PiezaRepository;
import com.practica.tallerMecanico.repositories.PiezasTrabajoRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

@Service

public class PiezasServicio implements IPiezas{


	
	@Autowired
	private PiezaRepository piezaRepository;
	
	@Autowired
    private TrabajoRepository trabajoRepository;
	
	@Autowired
    private PiezasTrabajoRepository pieTraRepository;

	@Override
    public List<Pieza> listarPiezas(String codigo,String nombre) {
		List<Pieza> piezas = new ArrayList<Pieza>();
		if(codigo != null && !codigo.trim().isEmpty()) {
			piezas =piezaRepository.findAllByCodigo(codigo);
		}else if(nombre != null && !nombre.trim().isEmpty()) {
			piezas =piezaRepository.findAllByNombre(nombre);
		}else {
			piezas = piezaRepository.findAll();
		}

        return piezas;
    }
	
	public List<Trabajo> listarTrabajosEnEjecucion(String matricula) {
        List<Trabajo> trabajosEnEjecucion = new ArrayList<Trabajo>();
        
        if(matricula != null && !matricula.trim().isEmpty()) {
        	trabajosEnEjecucion = trabajoRepository.findAllByEstadoAndMatricula(EstadoTrabajo.EJECUCION, matricula);
        }		
        return trabajosEnEjecucion;
    }
	
	public void agregarPiezas(Trabajo trabajo, Pieza pieza, Integer cantidad) {
		
		// CAMBIAR LAS EXCEPCIONES
//		if (trabajo == null) {
//            throw new IllegalArgumentException("El trabajo no puede ser nulo.");
//        }
//
//        if (pieza == null) {
//            throw new IllegalArgumentException("La pieza no puede ser nula.");
//        }
        
        PiezasTrabajo nuevaRelacion = new PiezasTrabajo();
        nuevaRelacion.setPieza(pieza);
        nuevaRelacion.setTrabajo(trabajo);
        nuevaRelacion.setCantidad(cantidad);        

        pieTraRepository.save(nuevaRelacion);
		 
	}
}
