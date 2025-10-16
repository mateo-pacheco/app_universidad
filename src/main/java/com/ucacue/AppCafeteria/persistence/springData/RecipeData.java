package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeData extends JpaRepository<RecipeEntity, Long> {
}
