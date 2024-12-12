package com.flashcardsystem.infrastructure.repository.entity;

import jakarta.persistence.*;

@Entity(name="Box")
public class BoxEntity {

    @Id
    private int id;
    private int frequency;

    public BoxEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "BoxEntity{" +
                "id='" + id + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
