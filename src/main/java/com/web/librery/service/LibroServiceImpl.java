package com.web.librery.service;

import com.web.librery.domain.Libro;
import com.web.librery.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    private LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository){
        this.libroRepository=libroRepository;
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> get(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public void update(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
}
