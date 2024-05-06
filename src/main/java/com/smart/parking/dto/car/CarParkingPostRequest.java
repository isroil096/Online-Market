package com.smart.parking.dto.car;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarParkingPostRequest {

    private String carName;
    private String numberPlate;
}
