package com.flashcardsystem.domain.port;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.model.Tag;

import java.util.List;

public interface CardRepository {
    Card create(Card card);
    Card update(Card card);
    void delete(String id);
    Card findById(String id);
    List<Card> findAll();
    List<Card> filterByTags(List<String> tags);
}
