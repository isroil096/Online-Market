package com.smart.parking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class CarRequest {

    private Long id;
    private String carName;
    private String numberPlate;
    private Set<ParkingRequest> parking;
}
