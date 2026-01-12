package com.sam.parking.repo;

import com.sam.parking.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
