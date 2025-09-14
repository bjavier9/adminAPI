package com.insurance.api.application.dto.generic;

import lombok.Data;

@Data
public class PeticionGenerica<T> {
    private T body;
}
