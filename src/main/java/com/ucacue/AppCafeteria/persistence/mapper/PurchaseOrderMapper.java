package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.PurchaseOrder;
import com.ucacue.AppCafeteria.persistence.entity.PurchaseOrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseOrderDetailMapper.class})
public interface PurchaseOrderMapper {
    // Entity to Model
    PurchaseOrder toPurchaseOrder(PurchaseOrderEntity purchaseOrderEntity);
    List<PurchaseOrder> toPurchaseOrders(List<PurchaseOrderEntity> purchaseOrderEntities);

    // Model to Entity
    PurchaseOrderEntity toPurchaseOrderEntity(PurchaseOrder purchaseOrder);
    List<PurchaseOrderEntity> toPurchaseOrdersEntity(List<PurchaseOrder> purchaseOrders);
}
