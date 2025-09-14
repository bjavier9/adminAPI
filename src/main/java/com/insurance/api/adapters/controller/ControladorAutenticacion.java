package com.insurance.api.adapters.controller;

import com.insurance.api.application.dto.SolicitudLogin;
import com.insurance.api.application.usecase.CasoDeUsoLogin;
import com.insurance.api.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class ControladorAutenticacion {

    private final CasoDeUsoLogin casoDeUsoLogin;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SolicitudLogin solicitudLogin) {
        Usuario usuario = new Usuario();
        usuario.setUsername(solicitudLogin.getUsername());
        usuario.setPassword(solicitudLogin.getPassword());
        String token = casoDeUsoLogin.ejecutar(usuario);
        return ResponseEntity.ok(token);
    }
}