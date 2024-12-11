package com.flashcardsystem.domain.model;

import com.flashcardsystem.infrastructure.repository.entity.CardEntity;

import java.util.Objects;
import java.util.Set;

public class Tag {
    private String id;
    private String name;
    private Set<CardEntity> cards;

    public Tag(String id, String name, Set<CardEntity> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CardEntity> getCards() {
        return cards;
    }

    public void setCards(Set<CardEntity> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(name, tag.name) && Objects.equals(cards, tag.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cards);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
