package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderData extends JpaRepository<PurchaseOrderEntity, Long> {
}
