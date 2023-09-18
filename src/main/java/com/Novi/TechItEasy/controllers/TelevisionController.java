package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.dtos.TelevisionInputDto;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import com.Novi.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;




@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
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

            return ResponseEntity.ok(televisionService.deleteTelevision(id));
    }
}
