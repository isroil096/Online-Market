package com.smart.parking.dto;

import com.smart.parking.entity.constants.CarCity;
import com.smart.parking.entity.constants.CarColor;
import com.smart.parking.entity.constants.CarName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SellerRequest {

    private Long id;
    private String phone;
    private Long price;
    private String model;
    private CarName name;
    private CarColor color;
    private CarCity city;
    private String type;
    private Long year;
}
