package com.flashcardsystem.infrastructure.repository;

import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.helper.BoxFixture;
import com.flashcardsystem.infrastructure.repository.entity.BoxEntity;
import com.flashcardsystem.infrastructure.repository.mapper.BoxMapper;
import com.flashcardsystem.infrastructure.repository.persistance.BoxPersistence;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
class BoxRepositoryImplTest {

    @Mock
    BoxPersistence boxPersistence;
    BoxRepositoryImpl boxRepository;

    @BeforeEach
    void setUp() {
        BoxMapper boxMapper = Mappers.getMapper(BoxMapper.class);
        boxRepository = new BoxRepositoryImpl(boxPersistence, boxMapper);
    }

    @Nested
    class FindById {
        @Test
        void shouldFindById() {
            // Given
            BoxEntity boxEntity = BoxFixture.buildBoxEntity();

            // When
            Mockito.when(boxPersistence.findById(1)).thenReturn(Optional.of(boxEntity));
            Box response = boxRepository.findById(1);

            //Then
            Box expectedBox = new Box(1, 1, List.of());
            assertEquals(expectedBox, response);
        }

        @Test
        void shouldNotFindById() {
            // Given + When
            Mockito.when(boxPersistence.findById(1)).thenReturn(Optional.empty());
            Box response = boxRepository.findById(1);

            //Then
            assertNull(response);
        }
    }
}