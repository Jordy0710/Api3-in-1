package com.cibertec.CL03.Api2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reservacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservacion_id")
    private Long id;

    @Column(name = "reservacion_fecha")
    private String fecha;

    @Column(name = "reservacion_nro_habitacion")
    private String nroHabitacion;

    @Column(name = "reservacion_costo")
    private double costo;

    @Column(name = "reservacion_create_date")
    private Date fechaCreacion;
}
