package com.insurance.api.domain.service;

import com.insurance.api.domain.model.Usuario;

public interface ServicioAutenticacion {
    String login(Usuario usuario);
}