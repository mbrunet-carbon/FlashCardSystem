package com.flashcardsystem.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashcardsystem.domain.model.Tag;
import com.flashcardsystem.infrastructure.repository.persistance.CardPersistence;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Sql(scripts = "/sqltesting/test-schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateCard() throws Exception {
        // Given
        CardDto cardDto = new CardDto(null, "Who is Zidane ?", "Football player", null);

        // When & Then
        mockMvc.perform(post("/card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cardDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.question").value("Who is Zidane ?"))
                .andExpect(jsonPath("$.answer").value("Football player"))
                .andExpect(jsonPath("$.tags").doesNotExist());
    }

    @Nested
    class Update {
        @Test
        void shouldUpdateCard() throws Exception {
            // Given
            CardDto cardDto = new CardDto("-1", "Is it an update ?", "yes", Set.of(new Tag(null, "easy")));

            // When & Then
            mockMvc.perform(put("/card")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(cardDto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").isNotEmpty())
                    .andExpect(jsonPath("$.question").value("Is it an update ?"))
                    .andExpect(jsonPath("$.answer").value("yes"))
                    .andExpect(jsonPath("$.tags").exists());
        }

        @Test
        void shouldNotFoundWhenUpdateCard() throws Exception {
            // Given
            CardDto cardDto = new CardDto("1", "Is it an update ?", "yes", Set.of(new Tag(null, "easy")));

            // When & Then
            mockMvc.perform(put("/card")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(cardDto)))
                    .andExpect(status().isNotFound());
        }
    }

    @Test
    void shouldFindAll() throws Exception {
        // Given + When + Then
        mockMvc.perform(get("/card")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].question").value("Who is Zidane ?"))
                .andExpect(jsonPath("$[0].answer").value("Football player"))
                .andExpect(jsonPath("$[0].tags").exists())
                .andExpect(jsonPath("$[1].id").isNotEmpty())
                .andExpect(jsonPath("$[1].question").value("An other question ?"))
                .andExpect(jsonPath("$[1].answer").value("yes"))
                .andExpect(jsonPath("$[1].tags").exists());
    }

    @Nested
    class Delete {
        @Test
        void shouldDeleteCard() throws Exception {
            // Given + When + Then
            mockMvc.perform(delete("/card/-1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        void shouldNotFoundWhenDeleteCard() throws Exception {
            //Given + When + Then
            mockMvc.perform(delete("/card/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
    }
}
