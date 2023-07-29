package com.web.librery.service;

import com.web.librery.domain.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);
    Optional<Usuario> fndUsuarioByEmail(String email);
}
