package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

public class ClienteDto implements Serializable {
    private final Long id;
    @Size(max = 80)
    @NotNull
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
    private final String correoElectronico;
    @Size(max = 100)
    @NotNull
    private final String nombres;
    @Size(max = 15)
    private final String telefonoLinea;

    public ClienteDto(Long id, String apellido, String celular, String calle, String codigoPostal, String departamento, String localidad, String numero, String piso, String correoElectronico, String nombres, String telefonoLinea) {
        this.id = id;
        this.apellido = apellido;
        this.celular = celular;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.departamento = departamento;
        this.localidad = localidad;
        this.numero = numero;
        this.piso = piso;
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.telefonoLinea = telefonoLinea;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefonoLinea() {
        return telefonoLinea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto entity = (ClienteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.apellido, entity.apellido) &&
                Objects.equals(this.celular, entity.celular) &&
                Objects.equals(this.calle, entity.calle) &&
                Objects.equals(this.codigoPostal, entity.codigoPostal) &&
                Objects.equals(this.departamento, entity.departamento) &&
                Objects.equals(this.localidad, entity.localidad) &&
                Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.piso, entity.piso) &&
                Objects.equals(this.correoElectronico, entity.correoElectronico) &&
                Objects.equals(this.nombres, entity.nombres) &&
                Objects.equals(this.telefonoLinea, entity.telefonoLinea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, celular, calle, codigoPostal, departamento, localidad, numero, piso, correoElectronico, nombres, telefonoLinea);
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
                "correoElectronico = " + correoElectronico + ", " +
                "nombres = " + nombres + ", " +
                "telefonoLinea = " + telefonoLinea + ")";
    }
}