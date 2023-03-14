package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.OrdenesTrabajo} entity
 */
public class OrdenesTrabajoDto implements Serializable {
    private final Long id;
    private final Integer cantidadCuotas;
    @Size(max = 255)
    private final String detalleFalla;
    @Size(max = 255)
    private final String estado;
    private final Instant fechaFinReparacion;
    private final Instant fechaIngreso;
    private final Instant fechaPago;
    @Size(max = 255)
    private final String formaPago;
    private final BigDecimal importeTotal;
    private final Long kilometraje;
    @Size(max = 255)
    private final String nivelCombustible;
    @Size(max = 255)
    private final String tipoTarjeta;

    public OrdenesTrabajoDto(Long id, Integer cantidadCuotas, String detalleFalla, String estado, Instant fechaFinReparacion, Instant fechaIngreso, Instant fechaPago, String formaPago, BigDecimal importeTotal, Long kilometraje, String nivelCombustible, String tipoTarjeta) {
        this.id = id;
        this.cantidadCuotas = cantidadCuotas;
        this.detalleFalla = detalleFalla;
        this.estado = estado;
        this.fechaFinReparacion = fechaFinReparacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaPago = fechaPago;
        this.formaPago = formaPago;
        this.importeTotal = importeTotal;
        this.kilometraje = kilometraje;
        this.nivelCombustible = nivelCombustible;
        this.tipoTarjeta = tipoTarjeta;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public String getDetalleFalla() {
        return detalleFalla;
    }

    public String getEstado() {
        return estado;
    }

    public Instant getFechaFinReparacion() {
        return fechaFinReparacion;
    }

    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public Instant getFechaPago() {
        return fechaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public String getNivelCombustible() {
        return nivelCombustible;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenesTrabajoDto entity = (OrdenesTrabajoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cantidadCuotas, entity.cantidadCuotas) &&
                Objects.equals(this.detalleFalla, entity.detalleFalla) &&
                Objects.equals(this.estado, entity.estado) &&
                Objects.equals(this.fechaFinReparacion, entity.fechaFinReparacion) &&
                Objects.equals(this.fechaIngreso, entity.fechaIngreso) &&
                Objects.equals(this.fechaPago, entity.fechaPago) &&
                Objects.equals(this.formaPago, entity.formaPago) &&
                Objects.equals(this.importeTotal, entity.importeTotal) &&
                Objects.equals(this.kilometraje, entity.kilometraje) &&
                Objects.equals(this.nivelCombustible, entity.nivelCombustible) &&
                Objects.equals(this.tipoTarjeta, entity.tipoTarjeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadCuotas, detalleFalla, estado, fechaFinReparacion, fechaIngreso, fechaPago, formaPago, importeTotal, kilometraje, nivelCombustible, tipoTarjeta);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cantidadCuotas = " + cantidadCuotas + ", " +
                "detalleFalla = " + detalleFalla + ", " +
                "estado = " + estado + ", " +
                "fechaFinReparacion = " + fechaFinReparacion + ", " +
                "fechaIngreso = " + fechaIngreso + ", " +
                "fechaPago = " + fechaPago + ", " +
                "formaPago = " + formaPago + ", " +
                "importeTotal = " + importeTotal + ", " +
                "kilometraje = " + kilometraje + ", " +
                "nivelCombustible = " + nivelCombustible + ", " +
                "tipoTarjeta = " + tipoTarjeta + ")";
    }
}