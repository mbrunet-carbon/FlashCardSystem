package com.flashcardsystem.infrastructure.repository.mapper;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.infrastructure.repository.entity.BoxEntity;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CardMapper {
    CardEntity toCardEntity(Card card);
    Card toCard(CardEntity cardEntity);
}
