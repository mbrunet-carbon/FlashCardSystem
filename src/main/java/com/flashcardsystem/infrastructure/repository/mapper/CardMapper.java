package com.flashcardsystem.infrastructure.repository.mapper;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CardMapper {

    CardEntity toCardEntity(Card card);
    Card toCard(CardEntity cardEntity);
}
