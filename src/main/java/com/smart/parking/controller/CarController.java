package com.smart.parking.controller;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.service.car.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping("/findBy/{numberPlate}")
    public CarRequest findByNumberPlate(@PathVariable String numberPlate) {
        return service.findByNumberPlate(numberPlate);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CarRequest request) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<?> update(@PathVariable("user_id") Integer userId, @RequestBody CarRequest request) {
        service.update(userId, request);
        return ResponseEntity.accepted().build();
    }
}
