package com.besysoft.taller_mecanico.domain.entity;

import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;

    @Size(max = 255)
    @Column(name = "detalle_falla")
    private String detalleFalla;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoOrdenEnum estado;

    @Column(name = "fecha_fin_reparacion")
    private LocalDateTime fechaFinReparacion;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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