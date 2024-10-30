package com.smart.parking.dto;

import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotorbikeDto {
    private MotoMake make;
    private String name;
    private MotoColor color;
    private MotoCity city;
    private Long year;
}
