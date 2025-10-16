package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.PurchaseOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDetailData extends JpaRepository<PurchaseOrderDetailEntity, Long> {
}
