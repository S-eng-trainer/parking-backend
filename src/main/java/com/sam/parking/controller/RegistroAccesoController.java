package com.sam.parking.controller;

import com.sam.parking.model.RegistroAcceso;
import com.sam.parking.model.Vehiculo;
import com.sam.parking.model.Celda;
import com.sam.parking.repo.RegistroAccesoRepository;
import com.sam.parking.repo.VehiculoRepository;
import com.sam.parking.repo.CeldaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroAccesoController {

    private final RegistroAccesoRepository repo;
    private final VehiculoRepository vehRepo;
    private final CeldaRepository celdaRepo;

    public RegistroAccesoController(RegistroAccesoRepository repo, VehiculoRepository vehRepo, CeldaRepository celdaRepo) {
        this.repo = repo;
        this.vehRepo = vehRepo;
        this.celdaRepo = celdaRepo;
    }

    @GetMapping
    public List<RegistroAcceso> list() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RegistroAcceso r) {
        if (r.getVehiculo() != null && r.getVehiculo().getVehiculoID() != null) {
            var vo = vehRepo.findById(r.getVehiculo().getVehiculoID());
            if (vo.isEmpty()) return ResponseEntity.badRequest().body("Vehiculo no existe");
            r.setVehiculo(vo.get());
        }
        if (r.getCelda() != null && r.getCelda().getCeldaID() != null) {
            var co = celdaRepo.findById(r.getCelda().getCeldaID());
            if (co.isEmpty()) return ResponseEntity.badRequest().body("Celda no existe");
            r.setCelda(co.get());
        }
        r.setRegistroID(null);
        return ResponseEntity.ok(repo.save(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return repo.findById(id).map(existing -> {
            repo.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
