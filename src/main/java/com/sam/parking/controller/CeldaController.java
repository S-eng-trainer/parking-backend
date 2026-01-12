package com.sam.parking.controller;

import com.sam.parking.model.Celda;
import com.sam.parking.repo.CeldaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/celdas")
public class CeldaController {

    private final CeldaRepository repo;

    public CeldaController(CeldaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Celda> list() {
        return repo.findAll();
    }

    @PostMapping
    public Celda create(@RequestBody Celda c) {
        c.setCeldaID(null);
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return repo.findById(id).map(existing -> {
            repo.delete(existing);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
