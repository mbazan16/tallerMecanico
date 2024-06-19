package com.practica.tallerMecanico.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Filtro extends Pieza{

	private int tipo;
	
	public Filtro(int id, float precio,String nombre, int tipo) {
        super(id,nombre,precio);
        this.tipo = tipo;
    }
}
