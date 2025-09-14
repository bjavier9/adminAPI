package com.insurance.api.application.dto;

import lombok.Data;

@Data
public class SolicitudLogin {
    private String username;
    private String password;
}