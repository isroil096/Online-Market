package com.smart.parking.dto.parking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smart.parking.dto.car.CarParkingPostRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class ParkingPostRequest {

    @JsonProperty("parkingName")
    private String parkingName;
    private Set<CarParkingPostRequest> cars;
}
