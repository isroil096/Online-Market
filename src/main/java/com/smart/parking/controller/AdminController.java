package com.smart.parking.controller;

import com.smart.parking.dto.SellerRequestDto;
import com.smart.parking.entity.Seller;
import com.smart.parking.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/car")
public class AdminController {

    private final SellerService sellerService;


    @PutMapping("/upd/{id}")
    public ResponseEntity<SellerRequestDto> updateCard(@PathVariable Long id , @RequestBody SellerRequestDto carRequest) {
        sellerService.updateCar(id, carRequest);
        return ResponseEntity.ok(carRequest);
    }

    @DeleteMapping("/del/{id}")
    public void deleteCard(@PathVariable Long id) {
        sellerService.deleteCar(id);
    }

    @GetMapping("/get/all")
    public List<Seller> getAllCards() {
        return sellerService.findAll();
    }

}
