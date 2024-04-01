package com.cibertec.CL03.Api3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/integracion")
public class IntegracionController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Map<String, Object>> integrarDatos(@RequestBody Map<String, Object> requestData) {
        // Obtener datos de la reserva desde el JSON principal
        Map<String, Object> reservacionData = (Map<String, Object>) requestData.get("reservacion");

        // Llamar a la API de habitación para actualizar el estado
        String habitacionUrl = "http://localhost:8080/habitacion/" + reservacionData.get("habitacionId") + "/actualizar-estado";
        Habitacion habitacionActualizada = restTemplate.put(habitacionUrl, reservacionData.get("habitacion"), Habitacion.class);

        // Llamar a la API de reservación para crear una nueva reserva
        String reservacionUrl = "http://localhost:8080/reservacion/crear";
        Reservacion nuevaReservacion = restTemplate.postForObject(reservacionUrl, reservacionData, Reservacion.class);

        // Construir la respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("estado", "EN PROCESO");
        response.put("detalles", reservacionData);

        return ResponseEntity.ok(response);
    }
}