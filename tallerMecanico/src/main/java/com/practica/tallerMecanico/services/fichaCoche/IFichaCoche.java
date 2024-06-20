package com.practica.tallerMecanico.services.fichaCoche;

import java.util.Optional;

import com.practica.tallerMecanico.entities.Coche;

public interface IFichaCoche {

	
	public Optional<Coche> getCocheById(Long id);
//	
//	public List<Cliente> getClientesByCocheId(Long id);
}
