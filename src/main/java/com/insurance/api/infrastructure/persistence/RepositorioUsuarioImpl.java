package com.insurance.api.infrastructure.persistence;

import com.insurance.api.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioUsuarioImpl {

    public Optional<Usuario> findByUsername(String username) {
        if ("user".equals(username)) {
            Usuario usuario = new Usuario();
            usuario.setUsername("user");
            usuario.setPassword("password");
            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}