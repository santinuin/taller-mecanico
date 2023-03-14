package com.besysoft.taller_mecanico.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "vehiculos", indexes = {
        @Index(name = "patente_UNIQUE", columnList = "patente", unique = true)
})
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "anio")
    private Integer anio;

    @Size(max = 255)
    @Column(name = "color")
    private String color;

    @Size(max = 255)
    @Column(name = "marca")
    private String marca;

    @Size(max = 255)
    @Column(name = "modelo")
    private String modelo;

    @Size(max = 255)
    @Column(name = "patente")
    private String patente;

    @ManyToMany(mappedBy = "vehiculos", fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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

}