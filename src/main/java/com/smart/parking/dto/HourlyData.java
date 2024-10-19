package com.smart.parking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HourlyData {
    private List<Double> temperature_2m;
    private List<Double> relative_humidity_2m;
    private List<Double> wind_speed_10m;
}
