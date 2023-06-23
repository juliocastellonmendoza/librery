package com.web.librery.service;

import com.web.librery.domain.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    public Libro save(Libro libro);
    public Optional<Libro> get(Long id);
    public void update(Libro libro);
    public void delete(Long id);
    public List<Libro> findAll();
}
