package com.besysoft.taller_mecanico.business.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class ClienteDto implements Serializable {
    private Long id;
    @Size(max = 80)
    @NotBlank(message = "Este campo no puede estar vacío")
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
    @Email
    private String correoElectronico;
    @Size(max = 100)
    @NotBlank(message = "Este campo no puede estar vacío")
    private String nombres;
    @Size(max = 15)
    @Pattern(regexp = "^[0-9]*$", message = "Este campo solo puede contener dígitos")
    private String telefonoLinea;
    private List<VehiculoDto> vehiculos;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String apellido, String celular, String calle, String codigoPostal, String departamento, String localidad, String numero, String piso, String correoElectronico, String nombres, String telefonoLinea, List<VehiculoDto> vehiculos) {
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
        this.vehiculos = vehiculos;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefonoLinea() {
        return telefonoLinea;
    }

    public void setTelefonoLinea(String telefonoLinea) {
        this.telefonoLinea = telefonoLinea;
    }

    public List<VehiculoDto> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoDto> vehiculos) {
        this.vehiculos = vehiculos;
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
                Objects.equals(this.telefonoLinea, entity.telefonoLinea) &&
                Objects.equals(this.vehiculos, entity.vehiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, celular, calle, codigoPostal, departamento, localidad, numero, piso, correoElectronico, nombres, telefonoLinea, vehiculos);
    }
}