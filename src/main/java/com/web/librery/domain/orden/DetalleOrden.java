package com.web.librery.domain.orden;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "DetalleOrden")
@Table(name = "detalleorden")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

}
