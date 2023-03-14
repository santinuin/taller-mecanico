package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.besysoft.taller_mecanico.domain.entity.Empleado} entity
 */
public class EmpleadoDto implements Serializable {
    private final Long id;
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
    private final String nombres;
    @Size(max = 255)
    private final String tipoEmpleado;

    public EmpleadoDto(Long id, String apellido, String celular, String calle, String codigoPostal, String departamento, String localidad, String numero, String piso, String nombres, String tipoEmpleado) {
        this.id = id;
        this.apellido = apellido;
        this.celular = celular;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.numero = numero;
        this.piso = piso;
        this.nombres = nombres;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Long getId() {
        return id;
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

    public String getNombres() {
        return nombres;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoDto entity = (EmpleadoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.apellido, entity.apellido) &&
                Objects.equals(this.celular, entity.celular) &&
                Objects.equals(this.calle, entity.calle) &&
                Objects.equals(this.codigoPostal, entity.codigoPostal) &&
                Objects.equals(this.departamento, entity.departamento) &&
                Objects.equals(this.localidad, entity.localidad) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.piso, entity.piso) &&
                Objects.equals(this.nombres, entity.nombres) &&
                Objects.equals(this.tipoEmpleado, entity.tipoEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, celular, calle, codigoPostal, departamento, localidad, numero, piso, nombres, tipoEmpleado);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "apellido = " + apellido + ", " +
                "celular = " + celular + ", " +
                "calle = " + calle + ", " +
                "codigoPostal = " + codigoPostal + ", " +
                "departamento = " + departamento + ", " +
                "localidad = " + localidad + ", " +
                "numero = " + numero + ", " +
                "piso = " + piso + ", " +
                "nombres = " + nombres + ", " +
                "tipoEmpleado = " + tipoEmpleado + ")";
    }
}