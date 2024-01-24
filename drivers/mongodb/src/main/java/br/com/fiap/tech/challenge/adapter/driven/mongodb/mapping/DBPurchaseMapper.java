package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PurchaseEntity;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = { DBCustomerMapper.class, DBPurchaseItemMapper.class })
public abstract class DBPurchaseMapper {

    @Autowired
    private DBPaymentMapper paymentMapper;

    @Mapping(target = "uuid", source = "id")
    @Mapping(target = "cartUUID", source = "cartId")
    public abstract PurchaseEntity toEntity(PurchaseDTO source);

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "cartId", source = "cartUUID")
    public abstract PurchaseDTO toDTO(PurchaseEntity source);
}
