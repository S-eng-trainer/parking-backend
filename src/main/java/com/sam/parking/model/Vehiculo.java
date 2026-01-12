package com.sam.parking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehiculoID;

    @NotBlank
    @Column(unique = true)
    private String placa;

    private String marca;
    private String color;

    private String tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "residenteID")
    private Residente residente;

    // Getters and setters
    public Integer getVehiculoID() {
        return vehiculoID;
    }

    public void setVehiculoID(Integer vehiculoID) {
        this.vehiculoID = vehiculoID;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }
}
