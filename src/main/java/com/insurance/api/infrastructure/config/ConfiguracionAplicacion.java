package com.insurance.api.infrastructure.config;

import com.insurance.api.application.usecase.AutenticarUsuario;
import com.insurance.api.domain.service.ServicioAutenticacion;
import com.insurance.api.domain.service.ServicioAutenticacionImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Configuration
public class ConfiguracionAplicacion {

    @Bean
    public AutenticarUsuario autenticarUsuario(ServicioAutenticacion servicioAutenticacion) {
        return new AutenticarUsuario(servicioAutenticacion);
    }

    @Bean
    public ServicioAutenticacion servicioAutenticacion(JwtEncoder encoder, UserDetailsService userDetailsService) {
        return new ServicioAutenticacionImpl(encoder, userDetailsService);
    }
}