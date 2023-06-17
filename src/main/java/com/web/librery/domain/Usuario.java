package com.web.librery.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;
    private Boolean status;

    @OneToMany(mappedBy = "usuario")
    private List<Libros> libros;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
}
