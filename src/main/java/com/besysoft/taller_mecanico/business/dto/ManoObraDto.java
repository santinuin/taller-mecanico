package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.ManoObra} entity
 */
public class ManoObraDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String detalle;
    private final LocalTime duracionHs;

    public ManoObraDto(Long id, String detalle, LocalTime duracionHs) {
        this.id = id;
        this.detalle = detalle;
        this.duracionHs = duracionHs;
    }

    public Long getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public LocalTime getDuracionHs() {
        return duracionHs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManoObraDto entity = (ManoObraDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.detalle, entity.detalle) &&
                Objects.equals(this.duracionHs, entity.duracionHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detalle, duracionHs);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "detalle = " + detalle + ", " +
                "duracionHs = " + duracionHs + ")";
    }
}