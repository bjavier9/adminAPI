package com.insurance.api.application.port.output;

import com.insurance.api.domain.model.User;
import java.util.Optional;

public interface UserOutputPort {
    Optional<User> findByUsername(String username);
}
