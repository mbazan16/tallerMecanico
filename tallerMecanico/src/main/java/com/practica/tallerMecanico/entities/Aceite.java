package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aceite extends Pieza{

	private String viscosidad;
	
	public Aceite(int id, float precio,String nombre, String viscosidad) {
        super(id,nombre,precio);
        this.viscosidad = viscosidad;
    }
}
