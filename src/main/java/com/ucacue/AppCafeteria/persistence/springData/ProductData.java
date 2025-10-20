package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductData extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByCode(String code);
    List<ProductEntity> findAllByNameIgnoreCase(String name);
    List<ProductEntity> findByActiveTrue();
    List<ProductEntity> findByActiveFalse();
}
