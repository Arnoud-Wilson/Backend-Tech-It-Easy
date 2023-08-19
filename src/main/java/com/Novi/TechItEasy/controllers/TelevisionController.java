package com.Novi.TechItEasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TelevisionController {

    String[] televisionBrands = {"Sony", "Phillips", "LG"};
    List<String> televisionDatabase = new ArrayList<>(List.of(televisionBrands));



    @GetMapping(value ="/televisions")
    public ResponseEntity<List<String>> getTelevisions() {
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping(value ="/television/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionDatabase.get(id));
    }

    @PostMapping(value ="/television/add/{name}")
    private ResponseEntity<List<String>> ChangeTelevision(@PathVariable String name) {
        televisionDatabase.add(name);
        return ResponseEntity.ok(televisionDatabase);
    }

    @PutMapping(value ="/television/change/{id}/{name}")
    public ResponseEntity<List<String>> addTelevision(@PathVariable int id, @PathVariable String name) {
        televisionDatabase.set(id, name);
        return ResponseEntity.ok(televisionDatabase);
    }

    @DeleteMapping(value ="/television/delete/{id}")
    public ResponseEntity<List<String>> deleteTelevision(@PathVariable int id) {
        televisionDatabase.remove(id);
        return ResponseEntity.ok(televisionDatabase);
    }


}
