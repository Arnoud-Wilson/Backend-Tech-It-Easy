package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.entity.CI_ModuleDto;
import com.Novi.TechItEasy.dtos.entity.CI_ModuleInputDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.repositories.helpers.DtoConverters;
import com.Novi.TechItEasy.models.entity.CI_Module;
import com.Novi.TechItEasy.repositories.CI_ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CI_ModuleService {

    private final CI_ModuleRepository ci_moduleRepository;

    public CI_ModuleService(CI_ModuleRepository ci_moduleRepository) {
        this.ci_moduleRepository = ci_moduleRepository;
    }


    /// For fetching all CI modules currently in the database /////
    public List<CI_ModuleDto> getCiModules() {

        List<CI_Module> CI_Modules = new ArrayList<>(ci_moduleRepository.findAll());
        List<CI_ModuleDto> CI_ModuleDtos = new ArrayList<>();

        for (CI_Module ci_module : CI_Modules) {
            CI_ModuleDto dto = new CI_ModuleDto();
            DtoConverters.CI_ModuleDtoConverter(ci_module, dto);
            CI_ModuleDtos.add(dto);
        }

        if (CI_ModuleDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen CI modules om te laten zien");
        } else {
            return CI_ModuleDtos;
        }
    }


    /// For fetching one ci module by id /////
    public CI_ModuleDto getCiModule(Long id) {
        Optional<CI_Module> fetchedCiModule = ci_moduleRepository.findById(id);

        if (fetchedCiModule.isPresent()) {
            CI_ModuleDto dto = new CI_ModuleDto();
            DtoConverters.CI_ModuleDtoConverter(fetchedCiModule.get(), dto);
            return dto;

        } else {
            throw new RecordNotFoundException("We hebben geen ci module met dit ID.");
        }
    }


    /// For creating one new ci module in database /////
    public CI_ModuleDto createCiModule(CI_ModuleInputDto ci_module) {

        CI_Module newCiModule = new CI_Module();
        DtoConverters.CI_ModuleInputDtoConverter(newCiModule, ci_module);

        ci_moduleRepository.save(newCiModule);

        CI_ModuleDto dto = new CI_ModuleDto();
        DtoConverters.CI_ModuleDtoConverter(newCiModule, dto);


        return dto;
    }


    ///// For changing ci module in database /////
    public CI_ModuleDto changeCiModule(Long id, CI_ModuleDto ci_moduleDto) {

        Optional<CI_Module> databaseCiModule = ci_moduleRepository.findById(id);

        if (databaseCiModule.isPresent()) {
            CI_Module fetchedCiModule = databaseCiModule.get();

            if (ci_moduleDto.name != null) {
                fetchedCiModule.setName(ci_moduleDto.name);
            }
            if (ci_moduleDto.type != null) {
                fetchedCiModule.setType(ci_moduleDto.type);
            }
            if (ci_moduleDto.price != null) {
                fetchedCiModule.setPrice(ci_moduleDto.price);
            }

            ci_moduleRepository.save(fetchedCiModule);
            DtoConverters.CI_ModuleDtoConverter(ci_moduleRepository.findById(id).get(), ci_moduleDto);

            return ci_moduleDto;

        } else {
            throw new RecordNotFoundException("We hebben geen ci module met dit ID.");
        }
    }


    ///// For deleting ci module from database /////
    public String deleteCiModule(Long id) {
        if (ci_moduleRepository.existsById(id)) {
            ci_moduleRepository.deleteAllById(Collections.singleton(id));

            return "We hebben ci module met id: " + id + " uit de database verwijderd.";
        } else {
            throw new RecordNotFoundException("We hebben geen ci module met dit ID.");
        }
    }
}
