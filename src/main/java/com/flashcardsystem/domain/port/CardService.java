package com.flashcardsystem.domain.port;

import com.flashcardsystem.domain.model.Card;

import java.util.List;

public interface CardService {
    Card create(Card card);
    Card update(Card card);
    void delete(String id);
    List<Card> findAll();
}
