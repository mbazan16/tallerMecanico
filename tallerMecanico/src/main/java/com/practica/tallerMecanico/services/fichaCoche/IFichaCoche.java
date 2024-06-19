package com.practica.tallerMecanico.services.fichaCoche;

import java.util.List;
import java.util.Optional;

public interface IFichaCoche {

	public List<Coche> getAllCoches();
	
	public Optional<Coche> getCocheById(Integer id);
	
	public List<Cliente> getClientesByCocheId(Integer id);
}
