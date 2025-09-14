package com.insurance.api.application.usecase;

import com.insurance.api.domain.model.Usuario;
import com.insurance.api.domain.service.ServicioAutenticacion;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CasoDeUsoLogin {

    private final ServicioAutenticacion servicioAutenticacion;

    public String ejecutar(Usuario usuario) {
        return servicioAutenticacion.login(usuario);
    }
}