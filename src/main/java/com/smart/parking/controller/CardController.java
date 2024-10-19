package com.smart.parking.controller;

import com.smart.parking.dto.CardRequest;
import com.smart.parking.entity.Card;
import com.smart.parking.entity.User;
import com.smart.parking.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;


    @PostMapping("/create")
    public ResponseEntity<CardRequest> createCard(@RequestBody CardRequest cardRequest, @AuthenticationPrincipal User user) {
        cardService.addCard(cardRequest,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardRequest);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<CardRequest> updateCard(@PathVariable Long id ,@RequestBody CardRequest cardRequest) {
        cardService.updateCard(id, cardRequest);
        return ResponseEntity.ok(cardRequest);
    }

    @DeleteMapping("/del/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }

    @GetMapping("/get/all")
    public List<Card> getAllCards() {
        return cardService.findAll();
    }

}
