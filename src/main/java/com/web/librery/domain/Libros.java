package com.web.librery.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "Libros")
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String ruta;
    private String genero;
    private double precio;
    private String autor;
    private String formato;
    private Date fecha;
    private String argumento;
    private int cantidad;
    private int isbn;
    private Boolean status;

    @ManyToOne
    private Usuario usuario;



}
