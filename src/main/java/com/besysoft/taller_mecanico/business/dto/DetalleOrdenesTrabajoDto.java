package com.besysoft.taller_mecanico.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.DetalleOrdenesTrabajo} entity
 */
public class DetalleOrdenesTrabajoDto implements Serializable {
    private final Long id;
    private final Integer cantidad;
    private final BigDecimal valorTotal;

    public DetalleOrdenesTrabajoDto(Long id, Integer cantidad, BigDecimal valorTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleOrdenesTrabajoDto entity = (DetalleOrdenesTrabajoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cantidad, entity.cantidad) &&
                Objects.equals(this.valorTotal, entity.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, valorTotal);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cantidad = " + cantidad + ", " +
                "valorTotal = " + valorTotal + ")";
    }
}