package com.flashcardsystem.helper;

import com.flashcardsystem.infrastructure.repository.entity.CardEntity;

import java.util.Set;

public class CardFixture {

    public static CardEntity buildCardEntity() {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId("1");
        cardEntity.setQuestion("Who is Zidane ?");
        cardEntity.setAnswer("Football player");
        cardEntity.setTags(Set.of());
        cardEntity.setBoxId(1);

        return cardEntity;
    }
}
