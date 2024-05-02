package com.smart.parking.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParkingRequest {

    @JsonProperty("parkingName")
    private String parkingName;
}
