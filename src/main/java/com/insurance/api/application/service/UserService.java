package com.insurance.api.application.service;

import com.insurance.api.application.port.input.UserInputPort;
import com.insurance.api.application.port.output.UserOutputPort;
import com.insurance.api.domain.model.User;
import java.util.Optional;

public class UserService implements UserInputPort {

    private final UserOutputPort userOutputPort;

    public UserService(UserOutputPort userOutputPort) {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userOutputPort.findByUsername(username);
    }
}
