package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Sale;
import com.ucacue.AppCafeteria.persistence.entity.SaleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleDetailMapper.class})
public interface SaleMapper {
    // Entity to Model
    Sale toSale(SaleEntity saleEntity);
    List<Sale> toSales(List<SaleEntity> saleEntities);

    // Model to Entity
    SaleEntity toSaleEntity(Sale sale);
    List<SaleEntity> toSalesEntity(List<Sale> sales);
}
