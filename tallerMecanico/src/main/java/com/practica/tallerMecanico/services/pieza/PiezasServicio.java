package com.practica.tallerMecanico.services.pieza;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.tallerMecanico.entities.Pieza;
import com.practica.tallerMecanico.repositories.PiezaRepository;

@Service
public class PiezasServicio implements IPiezas{
	
	@Autowired
	private PiezaRepository piezaRepository;
	
	
	
	@Override
    public List<Pieza> listarPiezas(String codigo,String nombre) {
		List<Pieza> piezas = new ArrayList<Pieza>();
		if(codigo != null && !codigo.trim().isEmpty())
			piezas =piezaRepository.findByCodigo(codigo);
		else if(nombre != null && !nombre.trim().isEmpty())
			piezas =piezaRepository.findByNombre(nombre);
		else piezas = piezaRepository.findAll();
		
		
        return piezas;
    }
	

}
