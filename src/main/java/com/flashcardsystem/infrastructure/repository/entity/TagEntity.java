package com.flashcardsystem.infrastructure.repository.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="Tag")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<CardEntity> cards;

    public TagEntity() {}

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
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
