package main.java.br.com.fiap.tech.challenge.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.rest.resource.response.PaymentResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PaymentResponseMapper {

    PaymentResponse toResponse(PaymentDTO dto);
}
