package com.besysoft.taller_mecanico.business.dto;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class FormaPagoDto implements Serializable {

    @NotNull(message = "Este campo no puede estar vacío")
    private Long id;
    private Integer cantidadCuotas;
    private LocalDateTime fechaPago;
    @Size(max = 255)
    private String formaPago;
    private BigDecimal importeTotal;
    private String tipoTarjeta;

    public FormaPagoDto() {
    }

    public FormaPagoDto(Long id, Integer cantidadCuotas, LocalDateTime fechaPago, String formaPago, BigDecimal importeTotal, String tipoTarjeta) {
        this.id = id;
        this.cantidadCuotas = cantidadCuotas;
        this.fechaPago = fechaPago;
        this.formaPago = formaPago;
        this.importeTotal = importeTotal;
        this.tipoTarjeta = tipoTarjeta;
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

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPagoDto entity = (FormaPagoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cantidadCuotas, entity.cantidadCuotas) &&
                Objects.equals(this.fechaPago, entity.fechaPago) &&
                Objects.equals(this.formaPago, entity.formaPago) &&
                Objects.equals(this.importeTotal, entity.importeTotal) &&
                Objects.equals(this.tipoTarjeta, entity.tipoTarjeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadCuotas, fechaPago, formaPago, importeTotal, tipoTarjeta);
    }
}

