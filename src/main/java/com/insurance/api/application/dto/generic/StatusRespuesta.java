package com.insurance.api.application.dto.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusRespuesta {
    private int code;
    private String descripcion;
}
