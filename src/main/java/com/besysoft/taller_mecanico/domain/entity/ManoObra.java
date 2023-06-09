package com.besysoft.taller_mecanico.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.Duration;

@Entity
@Table(name = "mano_obra")
public class ManoObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "detalle")
    private String detalle;

    @Column(name = "duracion_hs")
    private Duration duracionHs;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenTrabajo ordenTrabajo;

    public ManoObra() {
    }

    public ManoObra(Long id, String detalle, Duration duracionHs, Mecanico mecanico, OrdenTrabajo ordenTrabajo) {
        this.id = id;
        this.detalle = detalle;
        this.duracionHs = duracionHs;
        this.mecanico = mecanico;
        this.ordenTrabajo = ordenTrabajo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Duration getDuracionHs() {
        return duracionHs;
    }

    public void setDuracionHs(Duration duracionHs) {
        this.duracionHs = duracionHs;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

}