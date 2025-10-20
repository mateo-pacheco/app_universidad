package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.PurchaseOrder;
import com.ucacue.AppCafeteria.domain.model.PurchaseOrderDetail;
import com.ucacue.AppCafeteria.persistence.entity.PurchaseOrderDetailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseOrderDetailMapper {
    // Entity to Model
    PurchaseOrderDetail toPurchaseOrderDetail(PurchaseOrderDetailEntity purchaseOrderDetailEntity);
    List<PurchaseOrderDetail> toPurchaseOrderDetails(List<PurchaseOrderDetailEntity> purchaseOrderDetailsEntity);

    // Model to Entity
    PurchaseOrderDetailEntity toPurchaseOrderDetailEntity(PurchaseOrderDetail purchaseOrderDetail);
    List<PurchaseOrderDetailEntity> toPurchaseOrderDetailsEntity(List<PurchaseOrderDetail> purchaseOrderDetails);
}
