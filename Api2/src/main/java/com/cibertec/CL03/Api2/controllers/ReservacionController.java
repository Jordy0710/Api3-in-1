package com.cibertec.CL03.Api2.controllers;

import com.cibertec.CL03.Api2.models.Reservacion;
import com.cibertec.CL03.Api2.repositories.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservacion")
public class ReservacionController {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @GetMapping
    public List<Reservacion> obtenerReservaciones() {
        return reservacionRepository.findAll();
    }

    @PutMapping("/crear")
    public ResponseEntity<String> crearReservacion(@RequestBody Reservacion nuevaReservacion) {
        // Seteamos la fecha de creación antes de guardar la nueva reservación
        nuevaReservacion.setFechaCreacion(new Date());

        // Implementar lógica para crear una nueva reservación utilizando PUT
        reservacionRepository.save(nuevaReservacion);
        return new ResponseEntity<>("Reservación creada correctamente", HttpStatus.CREATED);
    }
}