package com.smart.parking.service.parking;

import com.smart.parking.dto.parking.ParkingGetRequest;
import com.smart.parking.dto.parking.ParkingPostRequest;
import com.smart.parking.entity.User;

import java.util.List;

public interface ParkingService {

    void save(ParkingPostRequest request, User user);

    List<ParkingGetRequest> getParkingById(Long userId);

    ParkingGetRequest getByParkingId(Long parkingId);

    void deleteParkingById(Long parkingId);

    void update(Long parkingId, ParkingPostRequest parkingPostRequest);
}
