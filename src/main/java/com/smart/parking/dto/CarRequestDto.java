package com.smart.parking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequestDto {

    private String phone;
    private Long price;
    private String  model;
    private String name;
    private String color;
    private String type;
    private Long year;
}
