package com.flashcardsystem.domain.model;

import com.flashcardsystem.infrastructure.repository.entity.TagEntity;

import java.util.Objects;
import java.util.Set;

public class Card {
    private String id;
    private String question;
    private String answer;
    private Set<Tag> tags;

    public Card(String id, String question, String answer, Set<Tag> tags) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(question, card.question) && Objects.equals(answer, card.answer) && Objects.equals(tags, card.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, tags);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", tags=" + tags +
                '}';
    }
}
