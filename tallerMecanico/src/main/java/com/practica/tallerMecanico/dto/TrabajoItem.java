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
public class TrabajoItem {
	
	private String id_trabajo;
	private String documento;
	private String matricula;
	private LocalDateTime fechaProgram;
	private Integer prioridad;
	
	
	
}
