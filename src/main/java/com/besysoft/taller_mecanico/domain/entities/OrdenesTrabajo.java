package com.besysoft.taller_mecanico.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "ordenes_trabajo", indexes = {
        @Index(name = "fk_trabajo_administrativo_idx", columnList = "administrativo_id"),
        @Index(name = "fk_trabajo_vehiculo_idx", columnList = "vehiculo_id"),
        @Index(name = "fk_trabajo_recepcionista_idx", columnList = "recepcionista_id")
})
public class OrdenesTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;

    @Size(max = 255)
    @Column(name = "detalle_falla")
    private String detalleFalla;

    @Size(max = 255)
    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_fin_reparacion")
    private Instant fechaFinReparacion;

    @Column(name = "fecha_ingreso")
    private Instant fechaIngreso;

    @Column(name = "fecha_pago")
    private Instant fechaPago;

    @Size(max = 255)
    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "importe_total", precision = 19, scale = 2)
    private BigDecimal importeTotal;

    @Column(name = "kilometraje")
    private Long kilometraje;

    @Size(max = 255)
    @Column(name = "nivel_combustible")
    private String nivelCombustible;

    @Size(max = 255)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "administrativo_id")
    private Empleado administrativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recepcionista_id")
    private Empleado recepcionista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getFechaFinReparacion() {
        return fechaFinReparacion;
    }

    public void setFechaFinReparacion(Instant fechaFinReparacion) {
        this.fechaFinReparacion = fechaFinReparacion;
    }

    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Instant fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Instant getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Instant fechaPago) {
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

    public Empleado getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Empleado administrativo) {
        this.administrativo = administrativo;
    }

    public Empleado getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Empleado recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}