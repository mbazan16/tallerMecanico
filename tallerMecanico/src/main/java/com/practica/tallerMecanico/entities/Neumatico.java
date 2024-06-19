package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Neumatico extends Pieza{

	private String medida;
	
	public Neumatico(int id, float precio, String medida) {
        super(id,precio);
        this.medida = medida;
    }

}
