package com.smart.parking.dto.parking;

import com.smart.parking.dto.car.CarParkingGetRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class ParkingGetRequest {

    private Long id;
    private String parkingName;
    private Set<ParkingCarGetRequest> cars;
}
