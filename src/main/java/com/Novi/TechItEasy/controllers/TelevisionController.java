package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.exceptions.NameTooLongException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value ="/television/{id}")
    public ResponseEntity<Optional<Television>> getTelevision(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            return ResponseEntity.ok(televisionRepository.findById(id));
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    @PostMapping(value ="/television/add")
    private ResponseEntity<Television> ChangeTelevision(@RequestBody Television television) {
        if (television.getBrand() == null || television.getName() ==null) {
            throw new MinimalRequiredTelevisionException();
        } else {
            televisionRepository.save(television);
            return ResponseEntity.created(null).body(television);
        }
    }

//    @PutMapping(value ="/television/change/{id}")
//    public ResponseEntity<List<String>> addTelevision(@PathVariable int id, @RequestBody String name) {
//        televisionDatabase.set(id, name);
//        return ResponseEntity.ok(televisionDatabase);
//    }
//
//    @DeleteMapping(value ="/television/delete/{id}")
//    public ResponseEntity<List<String>> deleteTelevision(@PathVariable int id) {
//        televisionDatabase.remove(id);
//        return ResponseEntity.ok(televisionDatabase);
//    }
}
