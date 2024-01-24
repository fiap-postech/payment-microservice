package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.CustomerEntity;
import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBCustomerMapper {
    @Mapping(target = "id", source = "uuid")
    CustomerDTO toDTO(CustomerEntity entity);

    @Mapping(target = "uuid", source = "id")
    CustomerEntity toEntity(CustomerDTO dto);
}
