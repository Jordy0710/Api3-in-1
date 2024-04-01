package com.cibertec.CL03.Api1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitacion_id")
    private Long id;

    @Column(name = "habitacion_nro")
    private String nro;

    @Column(name = "habitacion_tipo")
    private String tipo;

    @Column(name = "habitacion_estado")
    private String estado;

    @Column(name = "habitacion_create_date")
    private Date fechaCreacion;
}