package com.flashcardsystem.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Card {
    private String id;
    private String question;
    private String answer;
    private Set<Tag> tags;
    private int boxId;
    private LocalDateTime createdAt;

    public Card(String id, String question, String answer, int boxId, Set<Tag> tags) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.boxId = boxId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(question, card.question) && Objects.equals(answer, card.answer) && Objects.equals(tags, card.tags) && Objects.equals(boxId, card.boxId) && Objects.equals(createdAt, card.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, tags, boxId, createdAt);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", tags=" + tags +
                ", boxId=" + boxId +
                ", createdAt=" + createdAt +
                '}';
    }
}
