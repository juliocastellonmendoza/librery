package com.web.librery.service;

import com.web.librery.domain.Libros;

import java.util.Optional;

public interface LibroService {
    public Libros save(Libros libros);
    public Optional<Libros> get(Long id);
    public void update(Libros libros);
    public void delete(Long id);
}
