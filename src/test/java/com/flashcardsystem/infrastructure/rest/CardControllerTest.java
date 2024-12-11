package com.flashcardsystem.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashcardsystem.infrastructure.repository.entity.CardEntity;
import com.flashcardsystem.infrastructure.repository.persistance.CardPersistence;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    CardPersistence cardPersistence;

    @Autowired
    private ObjectMapper objectMapper;

    // TODO : fix the test to use h2 db for testing purpose only
    @Test
    void createCard_ShouldReturnCreatedCard() throws Exception {
        // Given
        CardDto cardDto = new CardDto("1", "Who is Zidane?", "Football player", null);
        CardEntity cardEntity = new CardEntity("1", "Who is Zidane ?", "Football player", Set.of());

        // When & Then
        Mockito.when(cardPersistence.save(Mockito.eq(cardEntity))).thenReturn(cardEntity);
        mockMvc.perform(post("/card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cardDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.question").value("Who is Zidane?"))
                .andExpect(jsonPath("$.answer").value("Football player"))
                .andExpect(jsonPath("$.tags").doesNotExist());
    }
}
