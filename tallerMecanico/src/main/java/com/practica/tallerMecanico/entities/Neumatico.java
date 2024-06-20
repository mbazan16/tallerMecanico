package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Neumatico extends Pieza{

	private String medida;
	private String marca;
	
	public Neumatico(int id, float precio, String nombre, String medida, String marca) {
        super(id,nombre,precio);
        this.medida = medida;
    }

}
