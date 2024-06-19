package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Filtro extends Pieza{

	private String tipo;
	
	public Filtro(int id, float precio, String tipo) {
        super(id,precio);
        this.tipo = tipo;
    }
}
