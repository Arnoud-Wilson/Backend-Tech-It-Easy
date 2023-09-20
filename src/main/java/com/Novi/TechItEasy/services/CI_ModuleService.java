package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.CI_ModuleDto;
import com.Novi.TechItEasy.dtos.WallBracketDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.CI_Module;
import com.Novi.TechItEasy.models.WallBracket;
import com.Novi.TechItEasy.repositories.CI_ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//
//    /// For creating one new wall bracket in database /////
//    public WallBracketDto createWallBracket(WallBracketInputDto wallBracket) {
//
//        WallBracket newWallBracket = new WallBracket();
//        DtoConverters.wallBracketInputDtoConverter(newWallBracket, wallBracket);
//
//        wallBracketRepository.save(newWallBracket);
//
//        WallBracketDto dto = new WallBracketDto();
//        DtoConverters.wallBracketDtoConverter(newWallBracket, dto);
//
//
//        return dto;
//    }
//
//
//    ///// For changing wall bracket in database /////
//    public WallBracketDto changeWallBracket(Long id, WallBracketDto wallBracketDto) {
//
//        Optional<WallBracket> databaseWallBracket = wallBracketRepository.findById(id);
//
//        if (databaseWallBracket.isPresent()) {
//            WallBracket fetchedWallBracket = databaseWallBracket.get();
//
//            if (wallBracketDto.size != null) {
//                fetchedWallBracket.setSize(wallBracketDto.size);
//            }
//            if (wallBracketDto.adjustable != null) {
//                fetchedWallBracket.setAdjustable(wallBracketDto.adjustable);
//            }
//            if (wallBracketDto.name != null) {
//                fetchedWallBracket.setName(wallBracketDto.name);
//            }
//            if (wallBracketDto.price != null) {
//                fetchedWallBracket.setPrice(wallBracketDto.price);
//            }
//
//            wallBracketRepository.save(fetchedWallBracket);
//            DtoConverters.wallBracketDtoConverter(wallBracketRepository.findById(id).get(), wallBracketDto);
//
//            return wallBracketDto;
//
//        } else {
//            throw new RecordNotFoundException("We hebben geen muurbeugels met dit ID.");
//        }
//    }
//
//
//    ///// For deleting wall bracket from database /////
//    public String deleteWallBracket(Long id) {
//        if (wallBracketRepository.existsById(id)) {
//            wallBracketRepository.deleteAllById(Collections.singleton(id));
//
//            return "We hebben muurbeugel met id: " + id + " uit de database verwijderd.";
//        } else {
//            throw new RecordNotFoundException("We hebben geen muurbeugel met dit ID.");
//        }
//    }
}
