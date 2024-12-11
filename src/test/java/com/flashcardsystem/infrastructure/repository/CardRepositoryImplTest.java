package com.flashcardsystem.infrastructure.repository;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import com.flashcardsystem.infrastructure.repository.mapper.CardMapper;
import com.flashcardsystem.infrastructure.repository.persistance.CardPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CardRepositoryImplTest {

    @Mock
    CardPersistence cardPersistence;
    CardRepositoryImpl cardRepository;

    @BeforeEach
    void setup() {
        CardMapper cardMapper = Mappers.getMapper(CardMapper.class);
        cardRepository = new CardRepositoryImpl(cardPersistence, cardMapper);
    }

    @Test
    void shouldCreate() {
        // Given
        Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());
        CardEntity cardEntity = new CardEntity("1", "Who is Zidane ?", "Football player", Set.of());

        // When
        Mockito.when(cardPersistence.save(Mockito.eq(cardEntity))).thenReturn(cardEntity);
        Card cardResponse = cardRepository.create(card);

        // Then
        Assertions.assertEquals(cardResponse, card);
    }

    @Nested
    class FindById {
        @Test
        void shouldFindById() {
            // Given
            Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());
            CardEntity cardEntity = new CardEntity("1", "Who is Zidane ?", "Football player", Set.of());

            // When
            Mockito.when(cardPersistence.findById(Mockito.eq("1"))).thenReturn(Optional.of(cardEntity));
            Card cardResponse = cardRepository.findById(card.getId());

            // Then
            Assertions.assertEquals(cardResponse, card);
        }

        @Test
        void shouldNotFound() {
            // Given
            Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());

            // When
            Mockito.when(cardPersistence.findById(Mockito.eq("1"))).thenReturn(Optional.empty());
            Card cardResponse = cardRepository.findById(card.getId());

            // Then
            assertNull(cardResponse);
        }
    }

    @Test
    void shouldDelete() {
        // Given
       String id = "1";

        // When
        cardRepository.delete(id);

        // Then
        verify(cardPersistence, times(1)).deleteById(id);
    }

    @Test
    void shouldFindAll() {
        // Given + When
        CardEntity cardEntity = new CardEntity("1", "Who is Zidane ?", "Football player", Set.of());
        Mockito.when(cardPersistence.findAll()).thenReturn(List.of(cardEntity));
        List<Card> cardsResponse = cardRepository.findAll();

        // Then
        List<Card> expectedCards = List.of(new Card("1", "Who is Zidane ?", "Football player", Set.of()));
        Assertions.assertEquals(cardsResponse, expectedCards);
    }
}