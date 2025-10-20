package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.User;
import com.ucacue.AppCafeteria.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Entity to Model
    User toUser(UserEntity userEntity);
    List<User> toUsers(List<UserEntity> usersEntity);

    // Model to Entity
    UserEntity toUserEntity(User user);
    List<UserEntity> toUsersEntity(List<User> users);
}
