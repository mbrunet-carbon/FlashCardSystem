package com.flashcardsystem.infrastructure.repository;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.model.Tag;
import com.flashcardsystem.domain.port.CardRepository;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import com.flashcardsystem.infrastructure.repository.mapper.CardMapper;
import com.flashcardsystem.infrastructure.repository.persistance.CardPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CardRepositoryImpl implements CardRepository {
    private final CardPersistence cardPersistence;
    private final CardMapper cardMapper;

    public CardRepositoryImpl(CardPersistence cardPersistence, CardMapper cardMapper) {
        this.cardPersistence = cardPersistence;
        this.cardMapper = cardMapper;
    }

    @Override
    public Card create(Card card) {
        CardEntity cardEntity = cardMapper.toCardEntity(card);

        CardEntity cardEntityResponse = cardPersistence.save(cardEntity);

        return cardMapper.toCard(cardEntityResponse);
    }

    @Override
    public Card update(Card card) {
        CardEntity cardEntity = cardMapper.toCardEntity(card);

        CardEntity cardEntityResponse = cardPersistence.save(cardEntity);

        return cardMapper.toCard(cardEntityResponse);
    }

    @Override
    public void delete(String id) {
        cardPersistence.deleteById(id);
    }

    @Override
    public Card findById(String id) {
        Optional<CardEntity> cardEntity = cardPersistence.findById(id);
        return cardEntity.map(cardMapper::toCard).orElse(null);
    }

    @Override
    public List<Card> findAll() {
        return cardPersistence.findAll().stream().map(cardMapper::toCard).collect(Collectors.toList());
    }

    // TODO: Make test for this one
    @Override
    public List<Card> filterByTags(List<String> tags) {
        return cardPersistence.findCardsByTags(tags).stream().map(cardMapper::toCard).collect(Collectors.toList());
    }
}
