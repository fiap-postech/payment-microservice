package br.com.fiap.tech.challenge.driven.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.driven.consumer.resource.response.CartResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = { CustomerResultMapper.class, CartItemResponseMapper.class }
)
public interface CartResponseMapper {

    CartResponse toResponse(CartDTO source);
}
