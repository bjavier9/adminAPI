package com.insurance.api.domain.model;

import java.util.Set;

public record User(String username, String password, Set<String> roles) {
}
