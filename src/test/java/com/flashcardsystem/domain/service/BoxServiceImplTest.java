package com.flashcardsystem.domain.service;

import com.flashcardsystem.domain.exception.BoxNotFoundException;
import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.domain.port.BoxRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class BoxServiceImplTest {

    @Mock
    BoxRepository boxRepository;
    BoxServiceImpl boxService;


    @BeforeEach
    void setUp() {
        boxService = new BoxServiceImpl(boxRepository);
    }

    @Nested
    class FindById {
        @Test
        void shouldFindById() {
            // Given
            int id = 1;
            Box box = new Box(1,1, List.of());

            // When
            Mockito.when(boxRepository.findById(id)).thenReturn(box);
            Box result = boxService.findById(id);

            // Then
            assertEquals(box, result);
        }

        @Test
        void shouldThrowBoxNotFoundException() {
            // Given
            int id = 69;

            // When
            Mockito.when(boxRepository.findById(id)).thenReturn(null);

            // Then
            Assertions.assertThrows(BoxNotFoundException.class, () -> boxService.findById(id));
        }
    }
}