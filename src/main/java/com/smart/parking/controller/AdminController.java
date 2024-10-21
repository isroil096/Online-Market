package com.smart.parking.controller;

import com.smart.parking.dto.CarRequestDto;
import com.smart.parking.entity.Car;
import com.smart.parking.repository.CarRepository;
import com.smart.parking.repository.UserRepository;
import com.smart.parking.service.CarService;
import com.smart.parking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/car")
public class AdminController {

    private final CarService carService;


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

}
