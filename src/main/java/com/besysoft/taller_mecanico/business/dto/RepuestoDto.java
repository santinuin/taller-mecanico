package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.Repuesto} entity
 */
public class RepuestoDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String marca;
    @Size(max = 255)
    private final String modelo;
    @Size(max = 255)
    private final String respuesto;
    private final BigDecimal valor;

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

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getRespuesto() {
        return respuesto;
    }

    public BigDecimal getValor() {
        return valor;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "marca = " + marca + ", " +
                "modelo = " + modelo + ", " +
                "respuesto = " + respuesto + ", " +
                "valor = " + valor + ")";
    }
}