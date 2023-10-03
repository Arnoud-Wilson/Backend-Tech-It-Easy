package com.Novi.TechItEasy.services;


import com.Novi.TechItEasy.dtos.CiModuleDto;
import com.Novi.TechItEasy.dtos.CiModuleInputDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;

import com.Novi.TechItEasy.models.CiModule;
import com.Novi.TechItEasy.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }


    /// For fetching all CI modules currently in the database /////
    public List<CiModuleDto> getCiModules() {

        List<CiModule> CiModules = new ArrayList<>(ciModuleRepository.findAll());
        List<CiModuleDto> CiModuleDtos = new ArrayList<>();

        for (CiModule ciModule : CiModules) {
            CiModuleDto dto = new CiModuleDto();
            DtoConverters.CiModuleDtoConverter(ciModule, dto);
            CiModuleDtos.add(dto);
        }

        if (CiModuleDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen CI modules om te laten zien");
        } else {
            return CiModuleDtos;
        }
    }


    /// For fetching one ci module by id /////
    public CiModuleDto getCiModule(Long id) {
        Optional<CiModule> fetchedCiModule = ciModuleRepository.findById(id);

        if (fetchedCiModule.isPresent()) {
            CiModuleDto dto = new CiModuleDto();
            DtoConverters.CiModuleDtoConverter(fetchedCiModule.get(), dto);
            return dto;

        } else {
            throw new RecordNotFoundException("We hebben geen ci module met id: " + id + " in onze database.");
        }
    }


    /// For creating one new ci module in database /////
    public CiModuleDto createCiModule(CiModuleInputDto ciModule) {

        CiModule newCiModule = new CiModule();
        DtoConverters.CiModuleInputDtoConverter(newCiModule, ciModule);

        ciModuleRepository.save(newCiModule);

        CiModuleDto dto = new CiModuleDto();
        DtoConverters.CiModuleDtoConverter(newCiModule, dto);


        return dto;
    }


    ///// For changing ci module in database /////
    public CiModuleDto changeCiModule(Long id, CiModuleDto ciModuleDto) {

        Optional<CiModule> databaseCiModule = ciModuleRepository.findById(id);

        if (databaseCiModule.isPresent()) {
            CiModule fetchedCiModule = databaseCiModule.get();

            if (ciModuleDto.name != null) {
                fetchedCiModule.setName(ciModuleDto.name);
            }
            if (ciModuleDto.type != null) {
                fetchedCiModule.setType(ciModuleDto.type);
            }
            if (ciModuleDto.price != null) {
                fetchedCiModule.setPrice(ciModuleDto.price);
            }

            ciModuleRepository.save(fetchedCiModule);
            DtoConverters.CiModuleDtoConverter(ciModuleRepository.findById(id).get(), ciModuleDto);

            return ciModuleDto;

        } else {
            throw new RecordNotFoundException("We hebben geen ci module met id: " + id + " in onze database.");
        }
    }


    ///// For deleting ci module from database /////
    public String deleteCiModule(Long id) {
        if (ciModuleRepository.existsById(id)) {
            ciModuleRepository.deleteAllById(Collections.singleton(id));

            return "We hebben ci module met id: " + id + " uit de database verwijderd.";
        } else {
            throw new RecordNotFoundException("We hebben geen ci module met id: " + id + " in onze database.");
        }
    }
}
