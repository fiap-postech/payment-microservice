package br.com.fiap.tech.challenge.adapter.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CommonMapper.class, PurchaseItemMapper.class, CustomerMapper.class, PaymentMapper.class })
public interface PurchaseMapper {

    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    @Mapping(target = "uuid", source = "id", qualifiedByName = "generateUuid")
    Purchase toDomain(PurchaseDTO dto);

    @Mapping(target = "id", expression = "java(purchase.uuid().toString())")
    @Mapping(target = "total", expression = "java(purchase.total())")
    @Mapping(target = "items", source = "purchase", qualifiedByName = "getPurchaseItems")
    PurchaseDTO toDTO(Purchase purchase);

    @Named("getPurchaseItems")
    static List<PurchaseItemDTO> getPurchaseItems(Purchase purchase) {
        return purchase.items().stream()
                .map(PurchaseItemMapper.INSTANCE::toDTO)
                .toList();
    }
}
