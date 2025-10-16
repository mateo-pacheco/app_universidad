package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.CategoryConsumableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryConsumableData extends JpaRepository<CategoryConsumableEntity, Long> {
}
