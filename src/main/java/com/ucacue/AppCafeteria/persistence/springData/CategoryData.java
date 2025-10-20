package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.CategoryEntity;
import com.ucacue.AppCafeteria.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryData extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAllByNameIgnoreCase(String name);
    List<CategoryEntity> findByActiveTrue();
    List<CategoryEntity> findByActiveFalse();
}
