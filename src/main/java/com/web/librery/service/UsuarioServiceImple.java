package com.web.librery.service;

import com.web.librery.domain.Usuario;
import com.web.librery.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImple implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> fndUsuarioByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }

}
