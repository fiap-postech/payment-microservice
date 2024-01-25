package br.com.fiap.tech.challenge.driven.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.driven.consumer.resource.response.PaymentResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PaymentResponseConsumerMapper {

    PaymentResponse toResponse(PaymentDTO dto);
}
