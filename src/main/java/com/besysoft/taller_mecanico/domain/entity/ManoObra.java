package com.besysoft.taller_mecanico.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

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
    private LocalTime duracionHs;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_trabajo_id")
    private OrdenTrabajo ordenTrabajo;

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

    public LocalTime getDuracionHs() {
        return duracionHs;
    }

    public void setDuracionHs(LocalTime duracionHs) {
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