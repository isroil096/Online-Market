package com.smart.parking.controller;

import com.smart.parking.dto.parking.ParkingBarrierControl;
import com.smart.parking.dto.parking.ParkingGetRequest;
import com.smart.parking.dto.parking.ParkingPostRequest;
import com.smart.parking.entity.User;
import com.smart.parking.service.parking.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all/{userId}")
    public List<ParkingGetRequest> getParkingById(@PathVariable("userId") Long userId) {
        return parkingService.getParkingById(userId);
    }

    @GetMapping("/{parkingId}")
    public ParkingGetRequest getByParkingId(@PathVariable Long parkingId) {
        return parkingService.getByParkingId(parkingId);
    }

    @DeleteMapping("/{parkingId}")
    public ResponseEntity<?> delete(@PathVariable Long parkingId) {
        parkingService.deleteParkingById(parkingId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{parkingId}")
    public ResponseEntity<?> update(@PathVariable Long parkingId, @RequestBody ParkingPostRequest parkingPostRequest) {
        parkingService.update(parkingId, parkingPostRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/{parkingId}")
    public ParkingBarrierControl barrierController(@PathVariable Long userId, @PathVariable Long parkingId, @RequestBody ParkingBarrierControl parkingBarrierControl) {
        return parkingService.barrierController(parkingId, userId, parkingBarrierControl);
    }
}
