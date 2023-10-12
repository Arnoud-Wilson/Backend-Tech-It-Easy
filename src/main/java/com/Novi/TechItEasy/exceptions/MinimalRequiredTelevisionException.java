package com.Novi.TechItEasy.exceptions;


import java.io.Serial;

public class MinimalRequiredTelevisionException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public MinimalRequiredTelevisionException() {

        super();
    }

    public MinimalRequiredTelevisionException(String message) {

        super(message);
    }
}
