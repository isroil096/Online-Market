package com.smart.parking.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FrontedRequest {

    private String message;
    private String code;
    private String title;
    boolean success;
}
