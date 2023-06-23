package com.web.librery.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalles")
@Getter
@Setter
@EqualsAndHashCode
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    @OneToOne
    private Orden orden;

    @ManyToOne
    private Libro libro;

    public DetalleOrden() {
    }

    public DetalleOrden(Long id_detalle, String nombre, double cantidad, double precio, double total) {
        this.id_detalle = id_detalle;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
}
