package com.flashcardsystem.infrastructure.rest.mapper;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CardDtoMapper {
    Card toCard(CardDto cardDto);
}
