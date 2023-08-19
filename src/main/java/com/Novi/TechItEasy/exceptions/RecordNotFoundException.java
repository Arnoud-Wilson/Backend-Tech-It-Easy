package com.Novi.TechItEasy.exceptions;


// Deze klasse vormt onze custom exception
public class RecordNotFoundException extends RuntimeException {

    // Deze waarde is enkel nuttig voor serialization/deserialization. Dit hoeft niet in je code.
    private static final long serialVersionUID = 1L;

    // De exception zonder message
    public RecordNotFoundException() {

        super();

    }

    // De exception met message
    public RecordNotFoundException(String message) {

        super(message);

    }
}
