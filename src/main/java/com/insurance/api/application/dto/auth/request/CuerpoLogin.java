package com.insurance.api.application.dto.auth.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CuerpoLogin {
    @JsonProperty("user")
    private String username;
    private String password;
}
