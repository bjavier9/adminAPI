package com.insurance.api.infrastructure.config;

import com.insurance.api.application.dto.generic.RespuestaGenerica;
import com.insurance.api.domain.service.CredencialesInvalidasException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepcionesGlobales {

    private final ManejadorRespuestas manejadorRespuestas;

    public ManejadorExcepcionesGlobales(ManejadorRespuestas manejadorRespuestas) {
        this.manejadorRespuestas = manejadorRespuestas;
    }

    @ExceptionHandler(CredencialesInvalidasException.class)
    public ResponseEntity<RespuestaGenerica<Object>> handleCredencialesInvalidasException(CredencialesInvalidasException ex) {
        RespuestaGenerica<Object> respuesta = manejadorRespuestas.getRespuesta("credencialesInvalidas", null);
        return new ResponseEntity<>(respuesta, HttpStatus.UNAUTHORIZED);
    }
}
