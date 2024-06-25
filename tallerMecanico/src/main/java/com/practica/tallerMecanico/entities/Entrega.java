package com.practica.tallerMecanico.entities;

import java.time.LocalDateTime;

import com.practica.tallerMecanico.common.ReservaEstado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private LocalDateTime fechaRecogida;

	private String tipo;

	private Integer idCoche;

	private Integer idCliente;

	private Integer idTrabajo;
	
	private ReservaEstado reservaestado;

}
