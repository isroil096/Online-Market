package com.smart.parking.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class WeatherResponse {
    @JsonProperty("current")
    private CurrentWeather current;

    @JsonProperty("hourly")
    private HourlyData hourly;

}
