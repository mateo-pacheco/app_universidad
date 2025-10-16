package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDetailData extends JpaRepository<SaleDetailEntity, Long> {
}
