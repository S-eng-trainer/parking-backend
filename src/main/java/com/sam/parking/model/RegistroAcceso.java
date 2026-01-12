package com.sam.parking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registroID;

    @ManyToOne
    @JoinColumn(name = "vehiculoID")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "celdaID")
    private Celda celda;

    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @PrePersist
    public void prePersist() {
        if (fechaEntrada == null) fechaEntrada = LocalDateTime.now();
    }

    // Getters and setters
    public Integer getRegistroID() {
        return registroID;
    }

    public void setRegistroID(Integer registroID) {
        this.registroID = registroID;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
