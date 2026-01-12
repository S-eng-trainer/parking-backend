package com.sam.parking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer celdaID;

    @NotBlank
    @Column(unique = true)
    private String numeroCelda;

    private String tipoCelda = "Residente";
    private String estado = "Disponible";

    // Getters and setters
    public Integer getCeldaID() {
        return celdaID;
    }

    public void setCeldaID(Integer celdaID) {
        this.celdaID = celdaID;
    }

    public String getNumeroCelda() {
        return numeroCelda;
    }

    public void setNumeroCelda(String numeroCelda) {
        this.numeroCelda = numeroCelda;
    }

    public String getTipoCelda() {
        return tipoCelda;
    }

    public void setTipoCelda(String tipoCelda) {
        this.tipoCelda = tipoCelda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
