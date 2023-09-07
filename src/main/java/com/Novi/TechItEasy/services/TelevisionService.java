package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.dtos.TelevisionInputDto;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    /// For fetching all televisions currently in the database /////
    public List<TelevisionDto> getTelevisions() {

        List<Television> televisions = new ArrayList<>(televisionRepository.findAll());
        List<TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions) {
            TelevisionDto dto = TelevisionDto.fromTelevision(television);
            televisionDtos.add(dto);
        }

        if (televisionDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen televisies om te laten zien");
        } else {
            return televisionDtos;
        }
    }


    /// For fetching one television by id /////
    public TelevisionDto getTelevision(Long id) {
        Optional<Television> fetchedTelevision = televisionRepository.findById(id);

        if (fetchedTelevision.isPresent()) {
            TelevisionDto dto = TelevisionDto.fromTelevision(fetchedTelevision.get());
            return dto;
        } else {
            throw new RecordNotFoundException("We hebben geen televisie met dit id gevonden.");
        }
    }


    /// For creating one new television in database /////
    public TelevisionDto addTelevision(@RequestBody TelevisionInputDto television) {

        Television inputTelevision = television.toTelevision();

        televisionRepository.save(inputTelevision);

        TelevisionDto dto = TelevisionDto.fromTelevision(inputTelevision);


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + inputTelevision.getId()).toUriString());

        //TODO: return and use uri location
        return dto;


    }


}
