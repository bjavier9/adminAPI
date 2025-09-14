package com.insurance.api.infrastructure.config;

import com.insurance.api.application.usecase.AutenticarUsuario;
import com.insurance.api.domain.service.ServicioAutenticacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionCasosDeUso {

    @Bean
    public AutenticarUsuario autenticarUsuario(ServicioAutenticacion servicioAutenticacion) {
        return new AutenticarUsuario(servicioAutenticacion);
    }
}