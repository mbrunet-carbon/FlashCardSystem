package com.flashcardsystem.infrastructure.rest.dto;

import com.flashcardsystem.domain.model.Tag;

import java.util.Set;

public class CardDto {
    private String id;
    private String question;
    private String answer;
    private Set<Tag> tags;

    public CardDto(String id, String question, String answer, Set<Tag> tags) {
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
    public String toString() {
        return "CardDto{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", tags=" + tags +
                '}';
    }
}
