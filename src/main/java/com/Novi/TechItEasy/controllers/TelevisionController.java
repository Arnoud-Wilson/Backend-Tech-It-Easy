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
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        if (television.getBrand() == null || television.getName() == null) {
            throw new MinimalRequiredTelevisionException();
        } else {
            televisionRepository.save(television);
            return ResponseEntity.created(null).body(television);
        }
    }

    @PutMapping(value ="/televisions/{id}")
    public ResponseEntity<Optional<Television>> changeTelevision(@PathVariable Long id, @RequestBody Television television) {

        Optional<Television> databaseTelevision = televisionRepository.findById(id);

        if (databaseTelevision.isPresent()) {
            Television fetchedTelevision = databaseTelevision.get();

            if (television.getBrand() != null) {
                fetchedTelevision.setBrand(television.getBrand());
            }
            if (television.getName() != null) {
                fetchedTelevision.setName(television.getName());
            }
            if (television.getType() != null) {
                fetchedTelevision.setType(television.getType());
            }
            if (television.getPrice() != null) {
                fetchedTelevision.setPrice(television.getPrice());
            }
            if (television.getAvailableSize() != null) {
                fetchedTelevision.setAvailableSize(television.getAvailableSize());
            }
            if (television.getRefreshRate() != null) {
                fetchedTelevision.setRefreshRate(television.getRefreshRate());
            }
            if (television.getScreenType() != null) {
                fetchedTelevision.setScreenType(television.getScreenType());
            }
            if (television.getScreenQuality() != null) {
                fetchedTelevision.setScreenQuality(television.getScreenQuality());
            }
            if (television.getSmartTv() != null) {
                fetchedTelevision.setSmartTv(television.getSmartTv());
            }
            if (television.getWifi() != null) {
                fetchedTelevision.setWifi(television.getWifi());
            }
            if (television.getVoiceControl() != null) {
                fetchedTelevision.setVoiceControl(television.getVoiceControl());
            }
            if (television.getHdr() != null) {
                fetchedTelevision.setHdr(television.getHdr());
            }
            if (television.getBluetooth() != null) {
                fetchedTelevision.setBluetooth(television.getBluetooth());
            }
            if (television.getAmbiLight() != null) {
                fetchedTelevision.setAmbiLight(television.getAmbiLight());
            }
            //TODO: wat als cliënt er 0 van wil maken? Nog aanpassen!
            if (television.getOriginalStock() != 0) {
                fetchedTelevision.setOriginalStock(television.getOriginalStock());
            }
//            if (television.getSold() != 0) {
//                fetchedTelevision.setSold(television.getSold());
//            }

            televisionRepository.save(fetchedTelevision);

            return ResponseEntity.ok(televisionRepository.findById(id));

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @DeleteMapping(value ="/televisions/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteAllById(Collections.singleton(id));
            return ResponseEntity.ok("Deleted id: " + id  + " from database.");
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
