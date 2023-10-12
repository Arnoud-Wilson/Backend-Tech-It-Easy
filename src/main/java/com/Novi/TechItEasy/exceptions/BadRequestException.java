package com.Novi.TechItEasy.exceptions;

import java.io.Serial;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }
}
