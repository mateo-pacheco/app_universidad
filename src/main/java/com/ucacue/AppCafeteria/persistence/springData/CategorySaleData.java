package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.CategorySaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorySaleData extends JpaRepository<CategorySaleEntity, Long> {
}
