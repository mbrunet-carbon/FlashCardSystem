package com.flashcardsystem.domain.model;

import java.util.List;
import java.util.Objects;

public class Box {
    private int id;
    private int frequency;

    public Box(int id, int frequency, List<Card> cards) {
        this.id = id;
        this.frequency = frequency;
    }

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return id == box.id && frequency == box.frequency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, frequency);
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", frequency=" + frequency +
                '}';
    }
}
