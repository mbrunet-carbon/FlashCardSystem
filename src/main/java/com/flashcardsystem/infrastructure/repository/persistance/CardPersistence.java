package com.flashcardsystem.infrastructure.repository.persistance;

import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardPersistence extends JpaRepository<CardEntity, String> {

    @Query(value = "SELECT c.* FROM cards c " +
            "JOIN card_tag ct ON c.id = ct.card_id " +
            "JOIN tags t ON ct.tag_id = t.id " +
            "WHERE t.name IN :tagNames", nativeQuery = true)
    List<CardEntity> findCardsByTags(@Param("tagNames") List<String> tagNames);
}
