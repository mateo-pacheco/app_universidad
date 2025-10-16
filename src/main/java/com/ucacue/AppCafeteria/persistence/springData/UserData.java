package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<UserEntity, Long> {
}
