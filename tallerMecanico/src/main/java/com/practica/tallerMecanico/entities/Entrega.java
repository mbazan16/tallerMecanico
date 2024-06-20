package com.practica.tallerMecanico.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String 

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRecogida;

	private String tipo;

	private Integer idCoche;

	private Integer idCliente;

	private Integer idTrabajo;

}
