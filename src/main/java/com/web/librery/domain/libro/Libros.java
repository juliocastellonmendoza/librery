package com.web.librery.domain.libro;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

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


}
