package com.besysoft.taller_mecanico.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "apellido")
    private String apellido;

    @Size(max = 15)
    @Column(name = "celular", length = 15)
    private String celular;

    @Size(max = 255)
    @Column(name = "calle")
    private String calle;

    @Size(max = 255)
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Size(max = 255)
    @Column(name = "departamento")
    private String departamento;

    @Size(max = 255)
    @Column(name = "localidad")
    private String localidad;

    @Size(max = 255)
    @Column(name = "numero")
    private String numero;

    @Size(max = 255)
    @Column(name = "piso")
    private String piso;

    @Size(max = 255)
    @Column(name = "nombres")
    private String nombres;

    @Size(max = 255)
    @Column(name = "tipo_empleado")
    private String tipoEmpleado;

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

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

}