package com.besysoft.taller_mecanico.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "repuestos")
public class Repuesto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "marca")
    private String marca;

    @Size(max = 255)
    @Column(name = "modelo")
    private String modelo;

    @Size(max = 255)
    @Column(name = "respuesto")
    private String respuesto;

    @Column(name = "valor", precision = 19, scale = 2)
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRespuesto() {
        return respuesto;
    }

    public void setRespuesto(String respuesto) {
        this.respuesto = respuesto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}