package com.sam.parking.repo;

import com.sam.parking.model.Celda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeldaRepository extends JpaRepository<Celda, Integer> {
}
