package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.ComboEntity;
import br.com.fiap.tech.challenge.adapter.dto.ComboDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = { DBSingleProductMapper.class }
)
public interface DBComboProductMapper {

    @Mapping(target = "id", source = "uuid")
    ComboDTO toDTO(ComboEntity source);

    @Mapping(target = "uuid", source = "id")
    ComboEntity toEntity(ComboDTO combo);
}
