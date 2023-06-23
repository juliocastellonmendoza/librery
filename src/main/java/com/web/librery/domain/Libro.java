package com.web.librery.domain;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "libros")
@EqualsAndHashCode
@Getter

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libro;
    private String titulo;
    private String genero;
    private double precio;
    private String autor;
    private String forma;
    private String argumento;
    private int cantidad;
    private int isbn;
    private String ruta;


    @ManyToOne
    private Usuario usuario;

    public Libro(){}

    public Libro(Long id_libro, String titulo, String genero, double precio, String autor, String forma,
                 String argumento, int cantidad, int isbn, String ruta, Usuario usuario) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.autor = autor;
        this.forma = forma;
        this.argumento = argumento;
        this.cantidad = cantidad;
        this.isbn = isbn;
        this.ruta = ruta;
        this.usuario = usuario;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                ", autor='" + autor + '\'' +
                ", forma='" + forma + '\'' +
                ", argumento='" + argumento + '\'' +
                ", cantidad=" + cantidad +
                ", isbn=" + isbn +
                ", ruta='" + ruta + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
