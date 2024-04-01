package com.cibertec.CL03.Api2.repositories;

import com.cibertec.CL03.Api2.models.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
    // Puedes agregar métodos personalizados si es necesario
}