package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.ProductEntity;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBSingleProductMapper {
    @Mapping(target = "id", source = "uuid")
    ProductDTO toDTO(ProductEntity request);

    @Mapping(target = "uuid", source = "id")
    ProductEntity toEntity(ProductDTO source);
}
