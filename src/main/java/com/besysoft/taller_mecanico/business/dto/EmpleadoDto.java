package com.besysoft.taller_mecanico.business.dto;

import com.besysoft.taller_mecanico.domain.enumerations.TipoEmpleadoEnum;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

public class EmpleadoDto implements Serializable {
    private Long id;
    @Size(max = 255)
    private String apellido;
    @Size(max = 15)
    @Pattern(regexp = "^[0-9]*$", message = "Este campo solo puede contener dígitos")
    private String celular;
    @Size(max = 255)
    private String calle;
    @Size(max = 255)
    private String codigoPostal;
    @Size(max = 255)
    private String departamento;
    @Size(max = 255)
    private String localidad;
    @Size(max = 255)
    @Pattern(regexp = "^[0-9]*$", message = "Este campo solo puede contener dígitos")
    private String numero;
    @Size(max = 255)
    private String piso;
    @Size(max = 255)
    private String nombres;
    private TipoEmpleadoEnum tipoEmpleado;

    public EmpleadoDto() {
    }

    public EmpleadoDto(Long id, String apellido, String celular, String calle, String codigoPostal, String departamento, String localidad, String numero, String piso, String nombres, TipoEmpleadoEnum tipoEmpleado) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public TipoEmpleadoEnum getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleadoEnum tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
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
}