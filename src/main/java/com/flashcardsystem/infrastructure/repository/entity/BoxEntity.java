package com.flashcardsystem.infrastructure.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name="Box")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "category" }) })
public class BoxEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int category;
    private int frequency;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public BoxEntity() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BoxEntity{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", frequency=" + frequency +
                ", createdAt=" + createdAt +
                '}';
    }
}
