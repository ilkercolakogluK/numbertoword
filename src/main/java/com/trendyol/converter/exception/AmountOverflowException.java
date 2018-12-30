package com.trendyol.converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Amount is overflowed ...")
public class AmountOverflowException extends Exception {

    static final long serialVersionUID = -3387516993224229948L;


    public AmountOverflowException(String message) {
        super(message);
    }
}


