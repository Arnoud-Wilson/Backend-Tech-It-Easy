package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;


}
