package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.SaleDetail;
import com.ucacue.AppCafeteria.persistence.entity.SaleDetailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {
    // Entity to Model
    SaleDetail toSaleDetail(SaleDetailEntity saleDetailEntity);
    List<SaleDetail> toSaleDetails(List<SaleDetailEntity> saleDetailsEntity);

    // Model to Entity
    SaleDetailEntity toSaleDetailEntity(SaleDetail saleDetail);
    List<SaleDetailEntity> toSaleDetailsEntity(List<SaleDetail> saleDetails);
}
