package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleData extends JpaRepository<SaleEntity, Long> {
}
