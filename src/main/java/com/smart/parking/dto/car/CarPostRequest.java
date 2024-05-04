package com.smart.parking.dto.car;


import com.smart.parking.dto.parking.ParkingRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class CarPostRequest {

    private String carName;
    private String numberPlate;
    private Set<ParkingRequest> parking;
}
