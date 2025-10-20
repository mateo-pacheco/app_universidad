package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Role;
import com.ucacue.AppCafeteria.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper {
    // Entity to Model
    Role toRole(RoleEntity roleEntity);
    List<Role> toRoles(List<RoleEntity> roleEntities);

    // Model to Entity
    RoleEntity toRoleEntity(Role role);
    List<RoleEntity> toRolesEntity(List<Role> roles);
}
