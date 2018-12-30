package com.trendyol.converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid word found ...")
public class InvalidWordException extends Exception {

    static final long serialVersionUID = -3387516993224229237L;


    public InvalidWordException(String message) {
        super(message);
    }
}


