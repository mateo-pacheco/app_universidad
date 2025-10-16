package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.ProductoSaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleData extends JpaRepository<ProductoSaleEntity, Long> {
}
