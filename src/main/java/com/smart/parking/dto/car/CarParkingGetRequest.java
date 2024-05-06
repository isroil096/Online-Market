package com.smart.parking.dto.car;

import com.smart.parking.dto.parking.ParkingCarGetRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class CarParkingGetRequest {

    private Long id;
    private String carName;
    private String numberPlate;
    private Set<ParkingCarGetRequest> parkingGetRequests;
}
