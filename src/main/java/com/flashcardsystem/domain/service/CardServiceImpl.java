package com.flashcardsystem.domain.service;

import com.flashcardsystem.domain.exception.CardNotFoundException;
import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.port.CardRepository;
import com.flashcardsystem.domain.port.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    @Transactional
    public Card create(Card card) {
        return cardRepository.create(card);
    }

    @Override
    public Card update(Card card) {
        Card cardToFind = cardRepository.findById(card.getId());
        if (cardToFind != null) {
            return cardRepository.update(card);
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
}
