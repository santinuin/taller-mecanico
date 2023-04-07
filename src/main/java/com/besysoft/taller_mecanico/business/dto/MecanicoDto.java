package com.besysoft.taller_mecanico.business.dto;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

public class MecanicoDto implements Serializable {
    private Long id;
    private Character activo;
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
    private String especialidad;
    @Size(max = 255)
    private String nombres;

    public MecanicoDto() {
    }

    public MecanicoDto(Long id, Character activo, String apellido, String celular, String calle, String codigoPostal,
                       String departamento, String localidad, String numero, String piso, String especialidad, String nombres) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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
        return Objects.hash(id, activo, apellido, celular, calle, codigoPostal,
                departamento, localidad, numero, piso, especialidad, nombres);
    }
}