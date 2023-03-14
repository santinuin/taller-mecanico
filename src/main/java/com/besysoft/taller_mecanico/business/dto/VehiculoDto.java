package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.Vehiculo} entity
 */
public class VehiculoDto implements Serializable {
    private final Long id;
    private final Integer anio;
    @Size(max = 255)
    private final String color;
    @Size(max = 255)
    private final String marca;
    @Size(max = 255)
    private final String modelo;
    @Size(max = 255)
    private final String patente;

    public VehiculoDto(Long id, Integer anio, String color, String marca, String modelo, String patente) {
        this.id = id;
        this.anio = anio;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }

    public Long getId() {
        return id;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoDto entity = (VehiculoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.anio, entity.anio) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.marca, entity.marca) &&
                Objects.equals(this.modelo, entity.modelo) &&
                Objects.equals(this.patente, entity.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anio, color, marca, modelo, patente);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "anio = " + anio + ", " +
                "color = " + color + ", " +
                "marca = " + marca + ", " +
                "modelo = " + modelo + ", " +
                "patente = " + patente + ")";
    }
}