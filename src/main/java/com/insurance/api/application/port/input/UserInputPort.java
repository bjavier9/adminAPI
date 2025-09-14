package com.insurance.api.application.port.input;

import com.insurance.api.domain.model.User;
import java.util.Optional;

public interface UserInputPort {
    Optional<User> findByUsername(String username);
}
