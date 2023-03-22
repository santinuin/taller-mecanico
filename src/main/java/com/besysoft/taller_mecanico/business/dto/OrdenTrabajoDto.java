package com.besysoft.taller_mecanico.business.dto;

import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrdenTrabajoDto implements Serializable {
    private Long id;
    private Integer cantidadCuotas;
    @Size(max = 255)
    private String detalleFalla;
    private EstadoOrdenEnum estado;
    private LocalDateTime fechaFinReparacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaPago;
    @Size(max = 255)
    private String formaPago;
    private BigDecimal importeTotal;
    private Long kilometraje;
    @Size(max = 255)
    private String nivelCombustible;
    @Size(max = 255)
    private String tipoTarjeta;
    private VehiculoDto vehiculo;
    private Long mecanicoId;

    public OrdenTrabajoDto() {
    }

    public OrdenTrabajoDto(Long id, Integer cantidadCuotas, String detalleFalla, EstadoOrdenEnum estado, LocalDateTime fechaFinReparacion,
                           LocalDateTime fechaIngreso, LocalDateTime fechaPago, String formaPago, BigDecimal importeTotal, Long kilometraje,
                           String nivelCombustible, String tipoTarjeta, VehiculoDto vehiculo, Long mecanicoId) {
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
        this.vehiculo = vehiculo;
        this.mecanicoId = mecanicoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getDetalleFalla() {
        return detalleFalla;
    }

    public void setDetalleFalla(String detalleFalla) {
        this.detalleFalla = detalleFalla;
    }

    public EstadoOrdenEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrdenEnum estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaFinReparacion() {
        return fechaFinReparacion;
    }

    public void setFechaFinReparacion(LocalDateTime fechaFinReparacion) {
        this.fechaFinReparacion = fechaFinReparacion;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getNivelCombustible() {
        return nivelCombustible;
    }

    public void setNivelCombustible(String nivelCombustible) {
        this.nivelCombustible = nivelCombustible;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public VehiculoDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDto vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Long getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(Long mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenTrabajoDto entity = (OrdenTrabajoDto) o;
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
                Objects.equals(this.tipoTarjeta, entity.tipoTarjeta) &&
                Objects.equals(this.vehiculo, entity.vehiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadCuotas, detalleFalla, estado, fechaFinReparacion, fechaIngreso, fechaPago,
                formaPago, importeTotal, kilometraje, nivelCombustible, tipoTarjeta, vehiculo);
    }
}