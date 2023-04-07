package com.besysoft.taller_mecanico.domain.entity;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "clientes", indexes = {
        @Index(name = "correo_electronico_UNIQUE", columnList = "correo_electronico", unique = true)})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "apellido")
    @Size(max = 80)
    @NotNull
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
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Size(max = 15)
    @Column(name = "telefono_linea", length = 15)
    private String telefonoLinea;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_vehiculo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id"))
    private List<Vehiculo> vehiculos;

    public Cliente() {
    }

    public Cliente(Long id, String apellido, String celular, String calle, String codigoPostal, String departamento,
                   String localidad, String numero, String piso, String correoElectronico, String nombres,
                   String telefonoLinea, List<Vehiculo> vehiculos) {
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
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

}