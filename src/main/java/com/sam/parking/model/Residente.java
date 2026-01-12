package com.sam.parking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Residente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer residenteID;

    @NotBlank
    private String nombre;

    @NotBlank
    private String torre;

    @NotBlank
    private String apartamento;

    private String telefono;

    private String email;

    // Getters and setters
    public Integer getResidenteID() {
        return residenteID;
    }

    public void setResidenteID(Integer residenteID) {
        this.residenteID = residenteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
