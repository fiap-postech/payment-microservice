package br.com.fiap.tech.challenge.driven.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.CartItemDTO;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.driven.consumer.resource.response.CartItemResponse;
import br.com.fiap.tech.challenge.driven.consumer.resource.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class CartItemResponseMapper {

    @Autowired
    private ProductResponseConsumerMapper productResponseConsumerMapper;

    @Mapping(target = "product", source = "product", qualifiedByName = "getProductResponse")
    abstract CartItemResponse toCartItemResponse(CartItemDTO source);


    @Named("getProductResponse")
    ProductResponse getProductResponse(ProductDTO dto) {
        return productResponseConsumerMapper.toResponse(dto);
    }

}
