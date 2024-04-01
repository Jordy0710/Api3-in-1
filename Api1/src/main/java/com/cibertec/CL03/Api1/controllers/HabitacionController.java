package com.cibertec.CL03.Api1.controllers;

import com.cibertec.CL03.Api1.models.Habitacion;
import com.cibertec.CL03.Api1.repositories.IHabitacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    private IHabitacionDao habitacionRepository;

    @GetMapping
    public List<Habitacion> obtenerHabitaciones() {
        return habitacionRepository.findAll();
    }

    @PutMapping("/{id}/actualizar-estado")
    public Habitacion actualizarEstadoHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacionActualizada) {
        return habitacionRepository.save(habitacionActualizada);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearHabitacion(@RequestBody Habitacion nuevaHabitacion) {
        // Seteamos la fecha de creación antes de guardar la nueva habitación
        nuevaHabitacion.setFechaCreacion(new Date());

        // Implementar lógica para crear una nueva habitación
        habitacionRepository.save(nuevaHabitacion);
        return new ResponseEntity<>("Habitación creada correctamente", HttpStatus.CREATED);
    }
}