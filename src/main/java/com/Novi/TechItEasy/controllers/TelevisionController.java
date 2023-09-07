package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import com.Novi.TechItEasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        if (television.getBrand() == null || television.getName() == null) {
            throw new MinimalRequiredTelevisionException();
        } else {
            televisionRepository.save(television);

            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + television.getId()).toUriString());

            return ResponseEntity.created(uri).body(television);
        }
    }

    @PutMapping(value ="/{id}")
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
            if (television.getSold() != 0) {
                fetchedTelevision.setSold(television.getSold());
            }

            televisionRepository.save(fetchedTelevision);

            return ResponseEntity.ok(televisionRepository.findById(id));

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteAllById(Collections.singleton(id));
            return ResponseEntity.ok("Deleted id: " + id  + " from database.");
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
