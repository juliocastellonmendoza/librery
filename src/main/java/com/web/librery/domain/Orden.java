package com.web.librery.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ordenes")
@Getter
@Setter
@EqualsAndHashCode
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;


    @ManyToOne
    private Usuario usuario;

    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;

    public Orden() {
    }

    public Orden(Long id_orden, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
        this.id_orden = id_orden;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;

    }
}
