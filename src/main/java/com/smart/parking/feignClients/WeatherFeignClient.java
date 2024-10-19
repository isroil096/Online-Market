package com.smart.parking.feignClients;
import com.smart.parking.dto.WeatherResponse;
import feign.RequestLine;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-service",url = "https://api.open-meteo.com")
public interface WeatherFeignClient {

    @GetMapping("/v1/forecast")
    WeatherResponse getWeatherData(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("current") String current,
            @RequestParam("hourly") String hourly
    );

}
