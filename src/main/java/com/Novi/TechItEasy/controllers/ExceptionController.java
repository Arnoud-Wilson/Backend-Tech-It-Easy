package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.exceptions.NameTooLongException;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exception(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>("Dit ID is niet aanwezig in de database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NameTooLongException.class)
    public ResponseEntity<Object> exception(NameTooLongException exception) {
        return new ResponseEntity<>("De televisie naam mag uit maximaal 20 karakters bestaan", HttpStatus.BAD_REQUEST);
    }
}
