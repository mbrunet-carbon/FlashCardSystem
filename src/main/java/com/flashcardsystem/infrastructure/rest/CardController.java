package com.flashcardsystem.infrastructure.rest;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.port.CardService;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import com.flashcardsystem.infrastructure.rest.mapper.CardDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardController {
    private final CardService cardService;
    private final CardDtoMapper cardDtoMapper;

    public CardController(CardService cardService, CardDtoMapper cardDtoMapper) {
        this.cardService = cardService;
        this.cardDtoMapper = cardDtoMapper;
    }

    @PostMapping
    ResponseEntity<Card> create(CardDto cardDto) {
        Card card = cardDtoMapper.toCard(cardDto);

        Card response = cardService.create(card);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
