package com.smart.parking.controller;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;
import com.smart.parking.service.CarService;
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
    private final CarService carService;


    @PostMapping("/create")
    public ResponseEntity<CarRequest> createCard(@RequestBody CarRequest cardRequest, @AuthenticationPrincipal User user) {
        carService.addCard(cardRequest,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardRequest);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<CarRequest> updateCard(@PathVariable Long id , @RequestBody CarRequest cardRequest) {
        carService.updateCard(id, cardRequest);
        return ResponseEntity.ok(cardRequest);
    }

    @DeleteMapping("/del/{id}")
    public void deleteCard(@PathVariable Long id) {
        carService.deleteCard(id);
    }

    @GetMapping("/get/all")
    public List<Car> getAllCards() {
        return carService.findAll();
    }

}
