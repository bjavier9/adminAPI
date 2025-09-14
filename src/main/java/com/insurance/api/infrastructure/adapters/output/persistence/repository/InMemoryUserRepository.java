package com.insurance.api.infrastructure.adapters.output.persistence.repository;

import com.insurance.api.application.port.output.UserOutputPort;
import com.insurance.api.domain.model.User;
import com.insurance.api.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.insurance.api.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class InMemoryUserRepository implements UserOutputPort {

    private final UserPersistenceMapper userPersistenceMapper;
    private final Map<String, UserEntity> users;

    public InMemoryUserRepository(UserPersistenceMapper userPersistenceMapper) {
        this.userPersistenceMapper = userPersistenceMapper;
        this.users = Map.of(
                "user", new UserEntity("user", "$2a$10$9.0C4sB.gN/C2sA1ZQ/Lz.w5R0.fsj2y8/tG2Xm2bJ4L.zB5LzB5O", Set.of("USER"))
        );
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username))
                .map(userPersistenceMapper::toDomain);
    }
}
