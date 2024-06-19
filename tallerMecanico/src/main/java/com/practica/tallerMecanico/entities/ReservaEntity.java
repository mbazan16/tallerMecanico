package com.practica.tallerMecanico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservas")
@Data
public class ReservaEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String xx;

    @Column(name = "password", nullable = false)
    private String yy;

    @Column(name = "enabled", nullable = false)
    private Integer zz;
	

}
