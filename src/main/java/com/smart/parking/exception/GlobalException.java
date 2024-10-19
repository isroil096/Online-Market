package com.smart.parking.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<FrontedRequest> BadRequestException(final BadRequest ex) {
        FrontedRequest frontedRequest = new FrontedRequest();
        frontedRequest.setMessage(ex.getMessage());
        frontedRequest.setTitle("Bad Request");
        frontedRequest.setCode("404");
        frontedRequest.setSuccess(false);
        return ResponseEntity.status(400).body(frontedRequest);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<FrontedRequest> NoSuchException(final NoSuchElementException ex) {
        FrontedRequest frontedRequest = new FrontedRequest();
        frontedRequest.setMessage(ex.getMessage());
        frontedRequest.setTitle("No Such Element Exception");
        frontedRequest.setCode("404");
        frontedRequest.setSuccess(false);
        return ResponseEntity.status(400).body(frontedRequest);
    }

    @
    ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<FrontedRequest> UsernameNotFoundException(final UsernameNotFoundException ex) {
        FrontedRequest frontedRequest = new FrontedRequest();
        frontedRequest.setMessage(ex.getMessage());
        frontedRequest.setTitle("Username Not Found");
        frontedRequest.setCode("404");
        frontedRequest.setSuccess(false);
        return ResponseEntity.status(400).body(frontedRequest);
    }


    
}
