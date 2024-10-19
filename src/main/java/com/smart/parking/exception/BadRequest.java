package com.smart.parking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        super(message);
    }
}
