package com.flashcardsystem.infrastructure.rest;

import com.flashcardsystem.domain.model.Card;
import com.flashcardsystem.domain.port.CardService;
import com.flashcardsystem.infrastructure.rest.dto.CardDto;
import com.flashcardsystem.infrastructure.rest.mapper.CardDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<Card> create(@RequestBody CardDto cardDto) {
        Card card = cardDtoMapper.toCard(cardDto);

        Card response = cardService.create(card);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    ResponseEntity<Card> update(@RequestBody CardDto cardDto) {
        Card card = cardDtoMapper.toCard(cardDto);

        Card response = cardService.update(card);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    ResponseEntity<List<Card>> findAll() {
        List<Card> cards = cardService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(cards);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        cardService.delete(id);

        return ResponseEntity.ok().build();
    }
}
