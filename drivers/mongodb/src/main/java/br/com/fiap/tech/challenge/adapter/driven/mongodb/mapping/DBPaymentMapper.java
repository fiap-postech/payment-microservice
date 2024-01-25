package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBPaymentMapper {
    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "method", source = "method", qualifiedByName = "getPayment")
    PaymentDTO toDTO(PaymentEntity payment);

    @Mapping(target = "uuid", source = "id")
    @Mapping(target = "method", constant = "MERCADO_PAGO")
    PaymentEntity toEntity(PaymentDTO payment);

    @Named("getPayment")
    static PaymentMethod getPayment(String method) {
        if ("MERCADO_PAGO".equals(method)) {
            return PaymentMethod.PAID_MARKET;
        }

        throw new IllegalArgumentException();
    }
}
