package com.smart.parking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarRequest {

    private Long id;
    private String phone;
    private Long price;
    private String model;
    private String name;
    private String color;
    private String type;
    private Long year;
}
