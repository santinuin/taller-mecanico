package com.besysoft.taller_mecanico.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class ManoObraDto implements Serializable {
    private Long id;
    @Size(max = 255)
    private String detalle;
    private LocalTime duracionHs;
    private MecanicoDto mecanico;
    @JsonIgnoreProperties(value = "mecanicoId")
    private OrdenTrabajoDto ordenTrabajo;

    public ManoObraDto() {
    }

    public ManoObraDto(Long id, String detalle, LocalTime duracionHs, MecanicoDto mecanico, OrdenTrabajoDto ordenTrabajo) {
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

    public LocalTime getDuracionHs() {
        return duracionHs;
    }

    public void setDuracionHs(LocalTime duracionHs) {
        this.duracionHs = duracionHs;
    }

    public MecanicoDto getMecanico() {
        return mecanico;
    }

    public void setMecanico(MecanicoDto mecanico) {
        this.mecanico = mecanico;
    }

    public OrdenTrabajoDto getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajoDto ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManoObraDto entity = (ManoObraDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.detalle, entity.detalle) &&
                Objects.equals(this.duracionHs, entity.duracionHs) &&
                Objects.equals(this.mecanico, entity.mecanico) &&
                Objects.equals(this.ordenTrabajo, entity.ordenTrabajo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detalle, duracionHs, mecanico, ordenTrabajo);
    }
}