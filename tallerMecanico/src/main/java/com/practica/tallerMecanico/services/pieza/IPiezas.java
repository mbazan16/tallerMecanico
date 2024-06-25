package com.practica.tallerMecanico.services.pieza;

import java.util.List;

import com.practica.tallerMecanico.entities.Pieza;

public interface IPiezas {
	public List<Pieza> listarPiezas(String codigo,String nombre);

}
