package com.smart.parking.controller;

import com.smart.parking.dto.parking.ParkingPostRequest;
import com.smart.parking.entity.User;
import com.smart.parking.service.parking.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ParkingPostRequest parkingPostRequest, @AuthenticationPrincipal User user){
        parkingService.save(parkingPostRequest, user);
        return ResponseEntity.ok().build();
    }
}
