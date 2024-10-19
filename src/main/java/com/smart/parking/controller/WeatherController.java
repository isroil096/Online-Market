package com.smart.parking.controller;
import com.smart.parking.dto.WeatherResponse;
import com.smart.parking.feignClients.WeatherFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherFeignClient weatherFeignClient;

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        String current = "temperature_2m,wind_speed_10m";
        String hourly = "temperature_2m,relative_humidity_2m,wind_speed_10m";

        WeatherResponse response = weatherFeignClient.getWeatherData(latitude, longitude, current, hourly);
        return ResponseEntity.ok(response);
    }
}
