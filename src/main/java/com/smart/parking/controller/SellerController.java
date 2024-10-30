package com.smart.parking.controller;

import com.smart.parking.dto.MotorbikeDto;
import com.smart.parking.dto.SellerRequestDto;
import com.smart.parking.entity.Motorbike;
import com.smart.parking.entity.Seller;
import com.smart.parking.entity.User;
import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import com.smart.parking.service.MotoService;
import com.smart.parking.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seller")
public class SellerController {


    private final SellerService sellerService;
    private final MotoService motoService;

    //Car CRUD


    @PostMapping("/create/car")
    public ResponseEntity<SellerRequestDto> createCard(@RequestBody SellerRequestDto carRequest, @AuthenticationPrincipal User user) {
        sellerService.addCar(carRequest,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(carRequest);
    }

    @PutMapping("/upd/car/{id}")
    public ResponseEntity<SellerRequestDto> updateCard(@PathVariable Long id , @RequestBody SellerRequestDto carRequest) {
        sellerService.updateCar(id, carRequest);
        return ResponseEntity.ok(carRequest);
    }

    @DeleteMapping("/del/car/{id}")
    public void deleteCard(@PathVariable Long id) {
        sellerService.deleteCar(id);
    }

    @GetMapping("/get/car/all")
    public List<Seller> getAllCards() {
        return sellerService.findAll();
    }

    @GetMapping("/me/car")
    public Optional<List<Seller>> getCurrentUser(@AuthenticationPrincipal User user) {
        // Foydalanuvchining ID'sini olish
        Long userId = user.getId();

        // Foydalanuvchiga tegishli avtomobillarni olish
        Optional<List<Seller>> car = sellerService.findByUserId(userId);



        // Avtomobilni qaytarish
        return car;
    }




    //Motorbike CRUD
    @PostMapping("/create/moto")
    public ResponseEntity<MotorbikeDto> addMoto(@RequestBody MotorbikeDto motorbikeDto){
        motoService.addMoto(motorbikeDto);
        return ResponseEntity.ok(motorbikeDto);
    }

    @PutMapping("/upd/moto/{id}")
    public ResponseEntity<MotorbikeDto> updateMoto(@PathVariable Long id ,@RequestBody MotorbikeDto motorbikeDto){
        motoService.updateMoto(id,motorbikeDto);
        return ResponseEntity.ok(motorbikeDto);
    }

    @DeleteMapping("/del/moto/{id}")
    public void deleteMoto(@PathVariable Long id){
        motoService.deleteMoto(id);
    }

    @GetMapping("/get/all")
    public List<Motorbike> getAllMoto() {
        return motoService.findAll();
    }

}
