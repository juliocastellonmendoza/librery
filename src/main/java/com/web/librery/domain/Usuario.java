package com.web.librery.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table(name = "usuarios")
@Getter
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;


    @OneToMany(mappedBy = "usuario")
    private List<Libro> libros;


    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;


    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombre, String username, String email, String direccion, String telefono, String tipo, String password) {
        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.username=username;
        this.email=email;
        this.direccion=direccion;
        this.telefono=telefono;
        this.tipo=tipo;
        this.password=password;

    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipo='" + tipo + '\'' +
                ", password='" + password + '\'' +
                ", libros=" + libros +
                ", ordenes=" + ordenes +
                '}';
    }
}
