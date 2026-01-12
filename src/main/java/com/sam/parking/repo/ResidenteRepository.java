package com.sam.parking.repo;

import com.sam.parking.model.Residente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenteRepository extends JpaRepository<Residente, Integer> {
}
