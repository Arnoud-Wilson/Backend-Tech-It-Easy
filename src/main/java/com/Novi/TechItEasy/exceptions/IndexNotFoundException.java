package com.Novi.TechItEasy.exceptions;


public class IndexNotFoundException extends RuntimeException {

    public IndexNotFoundException() {

        super("We hebben geen televisie met dit id.");
    }

    public IndexNotFoundException(String message) {

        super(message);
    }
}
