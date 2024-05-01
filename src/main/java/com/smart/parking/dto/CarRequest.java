package com.smart.parking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarRequest {

    private Integer id;
    private String carName;
    private String numberPlate;
}
