package com.smart.parking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {

    private Long number;
    private String type;
    private Long code;
}
