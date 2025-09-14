package com.insurance.api.infrastructure.adapters.output.persistence.mapper;

import com.insurance.api.domain.model.User;
import com.insurance.api.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.username(), user.password(), user.roles());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRoles());
    }
}
