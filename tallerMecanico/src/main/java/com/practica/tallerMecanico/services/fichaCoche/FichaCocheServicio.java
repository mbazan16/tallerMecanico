package com.practica.tallerMecanico.services.fichaCoche;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FichaCocheServicio implements IFichaCoche {

	Logger log = LoggerFactory.getLogger(FichaCocheServicio.class);

//	@Autowired
//	private CocheRepositorio cocheRepositorio; 

	public List<Coche> getAllCoches() {
		log.info("[getAllCoches]");

		List<Coche> coches = cocheRepositorio.findAll();

		coches.forEach(c -> log.debug(c.toString()));
	}

	public Optional<Coche> getCocheById(Integer id);

	public List<Cliente> getClientesByCocheId(Integer id);

	// Historico Trabajadores

}
