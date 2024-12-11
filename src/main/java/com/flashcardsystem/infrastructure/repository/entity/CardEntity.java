package com.flashcardsystem.infrastructure.repository.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name="Card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String question;
    private String answer;

    @ManyToMany
    @JoinTable(
            name= "card_tag",
            joinColumns = @JoinColumn(name="card_id"),
            inverseJoinColumns = @JoinColumn(name= "tag_id")
    )
    private Set<TagEntity> tags;

    public CardEntity(String id, String question, String answer, Set<TagEntity> tags) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.tags = tags;
    }

    public CardEntity() {}

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

    public Set<TagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(answer, that.answer) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, tags);
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", tags=" + tags +
                '}';
    }
}
