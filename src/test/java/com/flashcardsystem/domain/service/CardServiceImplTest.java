package com.flashcardsystem.domain.service;


import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.port.CardRepository;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CardServiceImplTest {


    @Mock
    CardRepository cardRepository;
    CardServiceImpl cardService;

    @BeforeEach
    void setup() {
        this.cardService = new CardServiceImpl(cardRepository);
    }

    @Test
    void shouldCreate() {
        // Given
        Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());

        // When
        Mockito.when(cardRepository.create(card)).thenReturn(card);
        Card cardResponse = cardService.create(card);

        // Then
        assertEquals(cardResponse, card);
    }

    @Nested
    class Update {
        @Test
        void shouldUpdate() {
            // Given
            Card cardToUpdate = new Card("1", "Who is toto ?", "A joker", Set.of());
            Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());

            // When
            Mockito.when(cardRepository.findById(cardToUpdate.getId())).thenReturn(card);
            Mockito.when(cardRepository.update(Mockito.eq(cardToUpdate))).thenReturn(cardToUpdate);
            Card cardResponse = cardService.update(cardToUpdate);

            // Then
            assertEquals(cardResponse, cardToUpdate);
        }

        @Test
        void shouldThrowCardNotFoundException() {
            // Given
            Card cardToUpdate = new Card("undefined", "Who is toto ?", "A joker", Set.of());

            // When
            Mockito.when(cardRepository.findById(cardToUpdate.getId())).thenReturn(null);

            // Then
            Assertions.assertThatThrownBy(() -> cardService.update(cardToUpdate));
        }
    }

    @Nested
    class Delete {
        @Test
        void shouldDelete() {
            // Given
            String id = "1";
            Card card = new Card("1", "Who is Zidane ?", "Football player", Set.of());

            // When
            Mockito.when(cardRepository.findById(id)).thenReturn(card);
            cardService.delete(id);

            // Then
            verify(cardRepository, times(1)).delete(id);
        }

        @Test
        void shouldThrowCardNotFoundException() {
            // Given
            String id = "undefined";

            // When
            Mockito.when(cardRepository.findById(id)).thenReturn(null);

            // Then
            Assertions.assertThatThrownBy(() -> cardService.delete(id));
        }
    }
    @Test
    void shouldListAllCards() {

        // Given + When
        List<Card> cards = List.of(new Card("1", "Who is Zidane ?", "Football player", Set.of()));
        Mockito.when(cardRepository.findAll()).thenReturn(cards);
        List<Card> cardsResponse = cardService.findAll();

        // Then
        assertEquals(cardsResponse, cards);
    }
}