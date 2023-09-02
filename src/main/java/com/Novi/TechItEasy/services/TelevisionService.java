package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

    public List<Television> getTelevisions() {

        return televisionRepository.findAll();
    }


}
