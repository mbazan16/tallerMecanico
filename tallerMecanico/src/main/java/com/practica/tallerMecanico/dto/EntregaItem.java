package com.practica.tallerMecanico.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EntregaItem {
	
	private String id_trabajo;
	private String matricula;
	private String documento;
	private LocalDateTime fechaFin;
	
}
