package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;



    public List<TelevisionDto> getTelevisions() {

        List<Television> televisions = new ArrayList<>(televisionRepository.findAll());
        List<TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions) {

            TelevisionDto dto = TelevisionDto.fromTelevision(television);
            televisionDtos.add(dto);
        }
        return televisionDtos;
    }




}
