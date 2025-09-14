package com.insurance.api.adapters.mapper;

import com.insurance.api.application.dto.auth.request.CuerpoLogin;
import com.insurance.api.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    /**
     * Convierte el DTO de la petición de login a una entidad de dominio Usuario.
     * @param cuerpoLogin El DTO con los datos de entrada.
     * @return Una entidad Usuario lista para ser usada por los casos de uso.
     */
    public Usuario toDomain(CuerpoLogin cuerpoLogin) {
        if (cuerpoLogin == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(cuerpoLogin.getUsername());
        usuario.setPassword(cuerpoLogin.getPassword());
        return usuario;
    }
}
