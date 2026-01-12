package com.sam.parking.controller;

import com.sam.parking.model.Vehiculo;
import com.sam.parking.repo.VehiculoRepository;
import com.sam.parking.repo.ResidenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository repo;
    private final ResidenteRepository residenteRepo;

    public VehiculoController(VehiculoRepository repo, ResidenteRepository residenteRepo) {
        this.repo = repo;
        this.residenteRepo = residenteRepo;
    }

    @GetMapping
    public List<Vehiculo> list() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Vehiculo v) {
        if (v.getResidente() != null && v.getResidente().getResidenteID() != null) {
            var resOpt = residenteRepo.findById(v.getResidente().getResidenteID());
            if (resOpt.isEmpty()) return ResponseEntity.badRequest().body("Residente no existe");
            v.setResidente(resOpt.get());
        }
        v.setVehiculoID(null);
        return ResponseEntity.ok(repo.save(v));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return repo.findById(id).map(existing -> {
            repo.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
