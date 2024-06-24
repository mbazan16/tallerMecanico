package com.practica.tallerMecanico.entities;

import java.util.Date;

import com.practica.tallerMecanico.common.ReservaEstado;

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
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReserva;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaProgramacion;

	private String prioridad;
	
	private ReservaEstado reservaEstado;

	private Integer idCoche;

	private Integer idCliente;

	private Integer idTrabajo;

}
