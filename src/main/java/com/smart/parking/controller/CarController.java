package com.smart.parking.controller;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;
import com.smart.parking.service.car.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping("/findBy/{numberPlate}")
    public CarRequest getByNumberPlate(@PathVariable String numberPlate) {
        return service.findByNumberPlate(numberPlate);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/without/parking")
    public ResponseEntity<?> save(@RequestBody CarRequest request, @AuthenticationPrincipal User user) {
        service.save(request, user);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<?> update(@PathVariable("user_id") Long userId, @RequestBody CarRequest request) {
        service.update(userId, request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/with/parking")
    public ResponseEntity<?> saveCar(@RequestBody CarRequest carRequest, @AuthenticationPrincipal User user) {
        service.saveCar(carRequest, user);
        return ResponseEntity.accepted().build();
    }
}
