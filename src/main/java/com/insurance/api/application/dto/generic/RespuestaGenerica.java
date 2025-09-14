package com.insurance.api.application.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaGenerica<T> {
    private T body;
    private StatusRespuesta status;
}
