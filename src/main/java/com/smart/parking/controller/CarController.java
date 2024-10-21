package com.smart.parking.controller;

import com.smart.parking.dto.CarRequestDto;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;
import com.smart.parking.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;


    @PostMapping("/create")
    public ResponseEntity<CarRequestDto> createCard(@RequestBody CarRequestDto carRequest, @AuthenticationPrincipal User user) {
        carService.addCard(carRequest,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(carRequest);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Optional<Car>> getCarByPhone(@PathVariable String phone) {
        Optional<Car> car = carService.findByPhone(phone);
        return ResponseEntity.ok(car);
    }
    @PutMapping("/upd/{id}")
    public ResponseEntity<CarRequestDto> updateCard(@PathVariable Long id , @RequestBody CarRequestDto carRequest) {
        carService.updateCard(id, carRequest);
        return ResponseEntity.ok(carRequest);
    }

    @DeleteMapping("/del/{id}")
    public void deleteCard(@PathVariable Long id) {
        carService.deleteCard(id);
    }

    @GetMapping("/get/all")
    public List<Car> getAllCards() {
        return carService.findAll();
    }

    @GetMapping("/me")
    public Optional<List<Car>> getCurrentUser(@AuthenticationPrincipal User user) {
        // Foydalanuvchining ID'sini olish
        Long userId = user.getId();

        // Foydalanuvchiga tegishli avtomobillarni olish
        Optional<List<Car>> car = carService.findByUserId(userId);



        // Avtomobilni qaytarish
        return car;
    }

}
