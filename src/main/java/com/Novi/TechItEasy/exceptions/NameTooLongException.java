package com.Novi.TechItEasy.exceptions;


public class NameTooLongException extends RuntimeException {

    public NameTooLongException() {

        super();
    }

    public NameTooLongException(String message) {

        super(message);
    }
}
