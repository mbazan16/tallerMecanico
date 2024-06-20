package com.practica.tallerMecanico.services.fichaCoche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practica.tallerMecanico.entities.Coche;
import com.practica.tallerMecanico.repositories.ClienteRepository;
import com.practica.tallerMecanico.repositories.CocheRepository;

@ExtendWith(MockitoExtension.class)
class FichaCocheServicioTest {

	private static final Logger log = LoggerFactory.getLogger(FichaCocheServicioTest.class);
	
	 @Mock
	    private CocheRepository cocheRepository;
	  @Mock
	    private ClienteRepository clienteRepository;

	    @InjectMocks
	    private FichaCocheServicio fichaCocheServicio;

	    private Coche coche;

	    @BeforeEach
	    public void setUp() {
	    	log.info("[Creación de instancia coche]");
	        coche = new Coche();
	        coche.setMatricula("AF2234");
	        coche.setKilometraje(1999);
	        coche.setMarca("Toyota");
	        coche.setModelo("Yaris");
	       
	    }
	 
	@Test
	public void testGetCocheById() {
		log.info("[testGetCocheById]");
		when(cocheRepository.findById(1L)).thenReturn(Optional.of(coche));
		
		Optional<Coche> resultado = fichaCocheServicio.getCocheById(1L);
		
		assertEquals(Optional.of(coche), resultado);
	}

}
