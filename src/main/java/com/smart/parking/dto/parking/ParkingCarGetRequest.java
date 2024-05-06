package com.smart.parking.dto.parking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingCarGetRequest {

    private Long id;
    private String carName;
    private String numberPlate;
}
