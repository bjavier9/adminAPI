package com.insurance.api.adapters.controller;

import com.insurance.api.adapters.mapper.LoginMapper;
import com.insurance.api.application.dto.auth.request.CuerpoLogin;
import com.insurance.api.application.dto.generic.PeticionGenerica;
import com.insurance.api.application.dto.generic.RespuestaGenerica;
import com.insurance.api.application.dto.auth.response.RespuestaLogin;
import com.insurance.api.application.usecase.AutenticarUsuario;
import com.insurance.api.domain.model.Usuario;
import com.insurance.api.infrastructure.config.ManejadorRespuestas;
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

    private final AutenticarUsuario autenticarUsuario;
    private final ManejadorRespuestas manejadorRespuestas;
    private final LoginMapper loginMapper;

    @PostMapping("/login")
    public ResponseEntity<RespuestaGenerica<RespuestaLogin>> login(@RequestBody PeticionGenerica<CuerpoLogin> peticion) {
        // 1. Mapear el DTO de entrada a la entidad de dominio
        Usuario usuario = loginMapper.toDomain(peticion.getBody());

        // 2. Ejecutar el caso de uso con la entidad de dominio
        String token = autenticarUsuario.ejecutar(usuario);

        // 3. Construir la respuesta genérica
        RespuestaLogin respuestaLogin = new RespuestaLogin(token);
        RespuestaGenerica<RespuestaLogin> respuesta = manejadorRespuestas.getRespuesta("exitoso", respuestaLogin);

        return ResponseEntity.ok(respuesta);
    }
}
