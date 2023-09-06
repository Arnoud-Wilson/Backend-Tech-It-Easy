package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.exceptions.IndexOutOfBoundsException;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    public List<TelevisionDto> getTelevisions() {

        List<Television> televisions = new ArrayList<>(televisionRepository.findAll());
        List<TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions) {
            TelevisionDto dto = TelevisionDto.fromTelevision(television);
            televisionDtos.add(dto);
        }

        if (televisionDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben helaas geen televisies gevonden.");
        } else {
            return televisionDtos;
        }
    }



    public TelevisionDto getTelevision(Long id) {
        Optional<Television> fetchedTelevision = televisionRepository.findById(id);

        if (fetchedTelevision.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen televisie met dit ID.");
        } else {
            TelevisionDto dto = TelevisionDto.fromTelevision(fetchedTelevision.get());
            return dto;
        }
    }




}
