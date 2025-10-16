package com.ucacue.AppCafeteria.persistence.springData;

import com.ucacue.AppCafeteria.persistence.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierData extends JpaRepository<SupplierEntity, Long> {
}
