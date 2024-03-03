package br.com.fiap.tech.challenge.adapter.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CommonMapper.class })
public interface PurchaseItemMapper {

    PurchaseItemMapper INSTANCE = Mappers.getMapper(PurchaseItemMapper.class);

    @Mapping(target = "id", expression = "java(item.id())")
    @Mapping(target = "title", expression = "java(item.title())")
    @Mapping(target = "description", expression = "java(item.description())")
    @Mapping(target = "categoryId", expression = "java(item.categoryId())")
    @Mapping(target = "quantity", expression = "java(item.quantity())")
    @Mapping(target = "currencyId", expression = "java(item.currencyId())")
    @Mapping(target = "unitPrice", expression = "java(item.unitPrice())")
    PurchaseItemDTO toDTO(PurchaseItem item);

    PurchaseItem toDomain(PurchaseItemDTO dto);

}
