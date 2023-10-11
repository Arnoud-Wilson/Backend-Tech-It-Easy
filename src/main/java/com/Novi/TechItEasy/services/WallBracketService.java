package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.*;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.WallBracket;
import com.Novi.TechItEasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }


    /// For fetching all wall brackets currently in the database /////
    public List<WallBracketDto> getWallBrackets() {

        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtos = new ArrayList<>();

        for (WallBracket wallBracket : wallBrackets) {
            WallBracketDto dto = new WallBracketDto();
            DtoConverters.wallBracketDtoConverter(wallBracket, dto);
            wallBracketDtos.add(dto);
        }

        if (wallBracketDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen muurbeugels om te laten zien");
        } else {
            return wallBracketDtos;
        }
    }


    /// For fetching one wall bracket by id /////
    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> fetchedWallBracket = wallBracketRepository.findById(id);

        if (fetchedWallBracket.isPresent()) {
            WallBracketDto dto = new WallBracketDto();
            DtoConverters.wallBracketDtoConverter(fetchedWallBracket.get(), dto);
            return dto;

        } else {
            throw new RecordNotFoundException("We hebben geen muurbeugel met id: " + id + " in onze database.");
        }
    }


    /// For creating one new wall bracket in database /////
    public WallBracketDto createWallBracket(WallBracketInputDto wallBracket) {

        WallBracket newWallBracket = new WallBracket();
        DtoConverters.wallBracketInputDtoConverter(newWallBracket, wallBracket);

        wallBracketRepository.save(newWallBracket);

        WallBracketDto dto = new WallBracketDto();
        DtoConverters.wallBracketDtoConverter(newWallBracket, dto);


        return dto;
    }


    ///// For changing wall bracket in database /////
    public WallBracketDto changeWallBracket(Long id, WallBracketDto wallBracketDto) {

        Optional<WallBracket> databaseWallBracket = wallBracketRepository.findById(id);

        if (databaseWallBracket.isPresent()) {
            WallBracket fetchedWallBracket = databaseWallBracket.get();

            if (wallBracketDto.size != null) {
                fetchedWallBracket.setSize(wallBracketDto.size);
            }
            if (wallBracketDto.adjustable != null) {
                fetchedWallBracket.setAdjustable(wallBracketDto.adjustable);
            }
            if (wallBracketDto.name != null) {
                fetchedWallBracket.setName(wallBracketDto.name);
            }
            if (wallBracketDto.price != null) {
                fetchedWallBracket.setPrice(wallBracketDto.price);
            }

            wallBracketRepository.save(fetchedWallBracket);
            DtoConverters.wallBracketDtoConverter(wallBracketRepository.findById(id).get(), wallBracketDto);

            return wallBracketDto;

        } else {
            throw new RecordNotFoundException("We hebben geen muurbeugel met id: " + id + " in onze database.");
        }
    }


    ///// For deleting wall bracket from database /////
    public String deleteWallBracket(Long id) {
        if (wallBracketRepository.existsById(id)) {
            wallBracketRepository.deleteAllById(Collections.singleton(id));

            return "We hebben muurbeugel met id: " + id + " uit de database verwijderd.";
        } else {
            throw new RecordNotFoundException("We hebben geen muurbeugel met id: " + id + " in onze database.");
        }
    }
}
