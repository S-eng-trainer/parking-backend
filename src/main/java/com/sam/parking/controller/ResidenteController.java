package com.sam.parking.controller;

import com.sam.parking.model.Residente;
import com.sam.parking.repo.ResidenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residentes")
public class ResidenteController {

    private final ResidenteRepository repo;

    public ResidenteController(ResidenteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Residente> list() {
        return repo.findAll();
    }

    @PostMapping
    public Residente create(@RequestBody Residente r) {
        r.setResidenteID(null);
        return repo.save(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return repo.findById(id).map(existing -> {
            repo.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
