package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.Mecanico} entity
 */
public class MecanicoDto implements Serializable {
    private final Long id;
    private final Character activo;
    @Size(max = 255)
    private final String apellido;
    @Size(max = 15)
    private final String celular;
    @Size(max = 255)
    private final String calle;
    @Size(max = 255)
    private final String codigoPostal;
    @Size(max = 255)
    private final String departamento;
    @Size(max = 255)
    private final String localidad;
    @Size(max = 255)
    private final String numero;
    @Size(max = 255)
    private final String piso;
    @Size(max = 255)
    private final String especialidad;
    @Size(max = 255)
    private final String nombres;

    public MecanicoDto(Long id, Character activo, String apellido, String celular, String calle, String codigoPostal, String departamento, String localidad, String numero, String piso, String especialidad, String nombres) {
        this.id = id;
        this.activo = activo;
        this.apellido = apellido;
        this.celular = celular;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.numero = numero;
        this.piso = piso;
        this.especialidad = especialidad;
        this.nombres = nombres;
    }

    public Long getId() {
        return id;
    }

    public Character getActivo() {
        return activo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getNombres() {
        return nombres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MecanicoDto entity = (MecanicoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.activo, entity.activo) &&
                Objects.equals(this.apellido, entity.apellido) &&
                Objects.equals(this.celular, entity.celular) &&
                Objects.equals(this.calle, entity.calle) &&
                Objects.equals(this.codigoPostal, entity.codigoPostal) &&
                Objects.equals(this.departamento, entity.departamento) &&
                Objects.equals(this.localidad, entity.localidad) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.piso, entity.piso) &&
                Objects.equals(this.especialidad, entity.especialidad) &&
                Objects.equals(this.nombres, entity.nombres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activo, apellido, celular, calle, codigoPostal, departamento, localidad, numero, piso, especialidad, nombres);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "activo = " + activo + ", " +
                "apellido = " + apellido + ", " +
                "celular = " + celular + ", " +
                "calle = " + calle + ", " +
                "codigoPostal = " + codigoPostal + ", " +
                "departamento = " + departamento + ", " +
                "localidad = " + localidad + ", " +
                "numero = " + numero + ", " +
                "piso = " + piso + ", " +
                "especialidad = " + especialidad + ", " +
                "nombres = " + nombres + ")";
    }
}