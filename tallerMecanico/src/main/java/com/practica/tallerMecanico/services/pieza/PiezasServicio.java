package com.practica.tallerMecanico.services.pieza;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.common.EstadoTrabajo;
import com.practica.tallerMecanico.entities.Pieza;
import com.practica.tallerMecanico.entities.Trabajo;
import com.practica.tallerMecanico.repositories.PiezaRepository;
import com.practica.tallerMecanico.repositories.TrabajoRepository;

@Service
public class PiezasServicio implements IPiezas{
	
	@Autowired
	private PiezaRepository piezaRepository;
	
	@Autowired
    private TrabajoRepository trabajoRepository;

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
        
        trabajosEnEjecucion = trabajoRepository.findAllByEstadoAndMatricula(EstadoTrabajo.EJECUCION, matricula);
        			
        return trabajosEnEjecucion;
    }
}
