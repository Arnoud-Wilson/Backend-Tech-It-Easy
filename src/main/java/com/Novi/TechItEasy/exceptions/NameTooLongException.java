package com.Novi.TechItEasy.exceptions;


// Deze klasse vormt onze custom exception
public class NameTooLongException extends RuntimeException {

    // De exception zonder message
    public NameTooLongException() {

        super();

    }

    // De exception met message
    public NameTooLongException(String message) {

        super(message);

    }
}
