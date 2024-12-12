package com.flashcardsystem.infrastructure.rest.mapper;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.infrastructure.repository.mapper.BoxMapper;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {BoxMapper.class})
public interface CardDtoMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "boxId", ignore = true)
    Card toCard(CardDto cardDto);
}
