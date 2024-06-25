package com.practica.tallerMecanico.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.practica.tallerMecanico.entities.Cliente;
import com.practica.tallerMecanico.entities.Coche;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Rollback
@Slf4j
class ClienteRepositoryTest {
	
	@Autowired
	ClienteRepository repository;
	
	@Autowired
	CocheRepository cocheRepository;
	
	
	@BeforeEach
	 void antes() {
		log.debug("[antes]");
		Coche coche = new Coche();
		coche.setId(1);
		coche.setMarca("XXX");
		coche.setModelo("YYYY");
		coche.setKilometraje(1000);
		Coche coche2 = new Coche();
		coche2.setId(2);
		coche2.setMarca("XXX");
		coche2.setModelo("YYYY");
		coche2.setKilometraje(2000);
		
		cocheRepository.save(coche);
		cocheRepository.save(coche2);
		Set<Coche> coches = new HashSet<Coche>();
		coches.add(coche);
		coches.add(coche2);
		
		Cliente cliente = new Cliente();
	    cliente.setDocumento("XXXX");
	    cliente.setNombre("XXXX");
	    cliente.setTelefono("11111");
	    cliente.setCoches(coches);
	    repository.save(cliente);
		
	}
	

	@Test
	void findAllByCocheId_ok() {
		log.debug("[findAllByCocheId_ok]");
		List<Cliente> clientes =repository.findAllByCocheId(1l);
		
		assertEquals(1, clientes.size());
		assertEquals("XXXX",clientes.get(0).getNombre());
		
	}
	
	@AfterEach
	void despues() {
		log.debug("[despues]");
		repository.deleteAll();
		cocheRepository.deleteAll();
	}

}
