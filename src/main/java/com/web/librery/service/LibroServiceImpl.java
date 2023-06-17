package com.web.librery.service;

import com.web.librery.domain.Libros;
import com.web.librery.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    private LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository){
        this.libroRepository=libroRepository;
    }

    @Override
    public Libros save(Libros libros) {
        return libroRepository.save(libros);
    }

    @Override
    public Optional<Libros> get(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public void update(Libros libros) {
        libroRepository.save(libros);
    }

    @Override
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}
