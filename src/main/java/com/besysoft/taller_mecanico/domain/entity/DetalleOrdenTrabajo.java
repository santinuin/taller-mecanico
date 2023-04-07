package com.besysoft.taller_mecanico.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_ordenes_trabajo")
public class DetalleOrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "valor_total", precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "repuesto_id")
    private Repuesto repuesto;

    public DetalleOrdenTrabajo() {
    }

    public DetalleOrdenTrabajo(Long id, Integer cantidad, BigDecimal valorTotal, OrdenTrabajo ordenTrabajo, Repuesto repuesto) {
        this.id = id;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.ordenTrabajo = ordenTrabajo;
        this.repuesto = repuesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

}