package com.besysoft.taller_mecanico.business.dto;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;


public class VehiculoDto implements Serializable {
    private Long id;
    private Integer anio;
    @Size(max = 255)
    private String color;
    @Size(max = 255)
    private String marca;
    @Size(max = 255)
    private String modelo;
    @Size(max = 255)
    private String patente;

    public VehiculoDto() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
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

}