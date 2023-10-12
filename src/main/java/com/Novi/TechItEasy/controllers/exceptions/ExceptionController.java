package com.Novi.TechItEasy.controllers.exceptions;

import com.Novi.TechItEasy.exceptions.BadRequestException;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> exception(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>("Dit ID is niet aanwezig in de database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MinimalRequiredTelevisionException.class)
    public ResponseEntity<String> exception(MinimalRequiredTelevisionException exception) {
        return new ResponseEntity<>("De televisie moet minimaal een merk en naam hebben", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> exception(BadRequestException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<String> exception(UsernameNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
