package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class TelevisionController {

    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @GetMapping(value ="/televisions")
    public ResponseEntity<List<Television>> getTelevisions() {

        return ResponseEntity.ok(televisionRepository.findAll());
    }

    @GetMapping(value ="/televisions/{id}")
    public ResponseEntity<Optional<Television>> getTelevision(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            return ResponseEntity.ok(televisionRepository.findById(id));
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    @PostMapping(value ="/televisions")
    private ResponseEntity<Television> ChangeTelevision(@RequestBody Television television) {
        if (television.getBrand() == null || television.getName() == null) {
            throw new MinimalRequiredTelevisionException();
        } else {
            televisionRepository.save(television);
            return ResponseEntity.created(null).body(television);
        }
    }

    @PutMapping(value ="/televisions/{id}")
    public ResponseEntity<Television> addTelevision(@PathVariable Long id, @RequestBody Television television) {


        return ResponseEntity.ok(television);
    }

    @DeleteMapping(value ="/televisions/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        televisionRepository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.ok("Deleted id: " + id  + " from database.");
    }
}
