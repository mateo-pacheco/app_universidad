package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.ConsumableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumableData extends JpaRepository<ConsumableEntity, Long> {
}
