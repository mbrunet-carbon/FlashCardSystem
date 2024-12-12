package com.flashcardsystem.domain.service;

import com.flashcardsystem.domain.exception.CardNotFoundException;
import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.model.Tag;
import com.flashcardsystem.domain.port.BoxService;
import com.flashcardsystem.domain.port.CardRepository;
import com.flashcardsystem.domain.port.CardService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class CardServiceImpl implements CardService {
    private static final int DEFAULT_BOX = 1;

    private final CardRepository cardRepository;
    private final BoxService boxService;

    public CardServiceImpl(CardRepository cardRepository, BoxService boxService) {
        this.cardRepository = cardRepository;
        this.boxService = boxService;
    }

    @Override
    @Transactional
    public Card create(Card card) {
        Box defaultBox = boxService.findById(DEFAULT_BOX);

        card.setBoxId(defaultBox.getId());

        return cardRepository.create(card);
    }

    @Override
    @Transactional
    public Card update(Card card) {
        Card cardToFind = cardRepository.findById(card.getId());
        if (cardToFind != null) {
            updateIfNotBlank(card, cardToFind);
            return cardRepository.update(cardToFind);
        }
        throw new CardNotFoundException(card.getId());
    }

    @Override
    public void delete(String id) {
        Card cardToFind = cardRepository.findById(id);
        if (cardToFind != null) {
            cardRepository.delete(id);
        } else {
            throw new CardNotFoundException(id);
        }
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    private void updateIfNotBlank(Card source, Card target) {
        if (StringUtils.isNotBlank(source.getQuestion())) {
            target.setQuestion(source.getQuestion());
        }
        if (StringUtils.isNotBlank(source.getAnswer())) {
            target.setAnswer(source.getAnswer());
        }
        if(source.getTags() != null && target.getTags() != null && !source.getTags().isEmpty()) {
            Set<Tag> tags = target.getTags();
            tags.addAll(source.getTags());
            target.setTags(tags);
        }
    }
}
