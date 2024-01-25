package br.com.fiap.tech.challenge.driven.consumer.mapping;


import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;
import br.com.fiap.tech.challenge.driven.consumer.resource.request.PaymentConfirmRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PaymentConfirmConsumerMapper {

    @Mapping(target = "apiVersion", source = "api_version")
    PaymentConfirmDTO toDTO(PaymentConfirmRequest request);
}
