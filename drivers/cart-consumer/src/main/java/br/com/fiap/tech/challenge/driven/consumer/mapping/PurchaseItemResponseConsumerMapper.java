package br.com.fiap.tech.challenge.driven.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;

import br.com.fiap.tech.challenge.driven.consumer.resource.response.ProductResponse;
import br.com.fiap.tech.challenge.driven.consumer.resource.response.PurchaseItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class PurchaseItemResponseConsumerMapper {

    @Autowired
    private ProductResponseConsumerMapper productResponseConsumerMapper;

    @Mapping(target = "product", source = "product", qualifiedByName = "getProductResponse")
    public abstract PurchaseItemResponse toResponse(PurchaseItemDTO dto);

    @Named("getProductResponse")
    ProductResponse getProductResponse(ProductDTO product) {
        return productResponseConsumerMapper.toResponse(product);
    }

}