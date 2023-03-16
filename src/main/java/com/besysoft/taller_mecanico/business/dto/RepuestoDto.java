package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class RepuestoDto implements Serializable {
    private Long id;
    @Size(max = 255)
    private String marca;
    @Size(max = 255)
    private String modelo;
    @Size(max = 255)
    private String respuesto;
    private BigDecimal valor;

    public RepuestoDto() {
    }

    public RepuestoDto(Long id, String marca, String modelo, String respuesto, BigDecimal valor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.respuesto = respuesto;
        this.valor = valor;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepuestoDto entity = (RepuestoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.marca, entity.marca) &&
                Objects.equals(this.modelo, entity.modelo) &&
                Objects.equals(this.respuesto, entity.respuesto) &&
                Objects.equals(this.valor, entity.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, respuesto, valor);
    }
}