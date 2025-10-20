package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.PurchaseOrder;
import com.ucacue.AppCafeteria.domain.model.Supplier;
import com.ucacue.AppCafeteria.persistence.entity.SupplierEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseOrder.class})
public interface SupplierMapper {
    // Entity to Model
    Supplier toSupplier(SupplierEntity supplierEntity);
    List<Supplier> toSuppliers(List<SupplierEntity> suppliersEntity);

    // Model to Entity
    SupplierEntity toSupplierEntity(Supplier supplier);
    List<SupplierEntity> toSuppliersEntity(List<Supplier> suppliers);
}
