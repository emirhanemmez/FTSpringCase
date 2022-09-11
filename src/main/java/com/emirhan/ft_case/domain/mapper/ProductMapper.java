package com.emirhan.ft_case.domain.mapper;

import com.emirhan.ft_case.data.entity.ProductEntity;
import com.emirhan.ft_case.domain.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @InheritInverseConfiguration
    Product mapToModel(ProductEntity productEntity);

    ProductEntity mapToEntity(Product product);
}
