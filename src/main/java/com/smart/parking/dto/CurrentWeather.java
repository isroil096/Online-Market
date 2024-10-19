package com.smart.parking.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class CurrentWeather {
    private double temperature_2m;
    private double wind_speed_10m;
}
