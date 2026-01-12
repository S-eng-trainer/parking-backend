package com.sam.parking.repo;

import com.sam.parking.model.RegistroAcceso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroAccesoRepository extends JpaRepository<RegistroAcceso, Integer> {
}
