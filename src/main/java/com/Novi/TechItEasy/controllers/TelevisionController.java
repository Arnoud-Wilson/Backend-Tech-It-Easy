package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.dtos.TelevisionInputDto;
import com.Novi.TechItEasy.exceptions.IndexNotFoundException;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import com.Novi.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/televisions")
public class TelevisionController {


    private final TelevisionRepository televisionRepository;
    private final TelevisionService televisionService;

    public TelevisionController(TelevisionRepository televisionRepository, TelevisionService televisionService) {
        this.televisionRepository = televisionRepository;
        this.televisionService = televisionService;
    }



    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getTelevisions() {

        return ResponseEntity.ok(televisionService.getTelevisions());
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {

        return ResponseEntity.ok(televisionService.getTelevision(id));
    }


    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@RequestBody TelevisionInputDto television) {
        if (television.getBrand() == null || television.getName() == null) {
            throw new MinimalRequiredTelevisionException();
        } else {
            return ResponseEntity.created(null).body(televisionService.addTelevision(television));
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<TelevisionDto> changeTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto television) {

            return ResponseEntity.ok(televisionService.changeTelevision(id, television));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteAllById(Collections.singleton(id));
            return ResponseEntity.ok("Deleted id: " + id  + " from database.");
        } else {
            throw new IndexNotFoundException("We hebben geen televisie met dit id.");
        }
    }
}
