package com.insurance.api.infrastructure.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.api.application.dto.generic.RespuestaGenerica;
import com.insurance.api.application.dto.generic.StatusRespuesta;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Component
public class ManejadorRespuestas {

    private JsonNode respuestas;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:api-responses.json");
        respuestas = mapper.readTree(file).get("respuestas");
    }

    public <T> RespuestaGenerica<T> getRespuesta(String tipoRespuesta, T data) {
        JsonNode respuestaNode = respuestas.get(tipoRespuesta);
        StatusRespuesta status = new StatusRespuesta(
                respuestaNode.get("code").asInt(),
                respuestaNode.get("descripcion").asText()
        );
        return new RespuestaGenerica<>(data, status);
    }

    public StatusRespuesta getStatus(String tipoRespuesta) {
        JsonNode respuestaNode = respuestas.get(tipoRespuesta);
        return new StatusRespuesta(
                respuestaNode.get("code").asInt(),
                respuestaNode.get("descripcion").asText()
        );
    }
}
