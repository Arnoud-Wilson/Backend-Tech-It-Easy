package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.*;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.WallBracket;
import com.Novi.TechItEasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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

        List<WallBracket> wallBrackets = new ArrayList<>(wallBracketRepository.findAll());
        List<WallBracketDto> wallBracketDtos = new ArrayList<>();

        for (WallBracket wallBracket : wallBrackets) {
            WallBracketDto dto = new WallBracketDto();
            DtoConverters.wallBracketDtoConverter(wallBracket, dto);
            wallBracketDtos.add(dto);
        }

        if (wallBracketDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen muursteunen om te laten zien");
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
            throw new RecordNotFoundException("We hebben geen muurbeugel met dit ID.");
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

//
//    ///// For changing remote controller in database /////
//    public RemoteControllerDto changeRemoteController(Long id, RemoteControllerDto remoteControllerDto) {
//
//        Optional<RemoteController> databaseRemoteContoller = remoteControllerRepository.findById(id);
//
//        if (databaseRemoteContoller.isPresent()) {
//            RemoteController fetchedRemoteContoller = databaseRemoteContoller.get();
//
//            if (remoteControllerDto.compatibleWith != null) {
//                fetchedRemoteContoller.setCompatibleWith(remoteControllerDto.compatibleWith);
//            }
//            if (remoteControllerDto.batteryType != null) {
//                fetchedRemoteContoller.setBatteryType(remoteControllerDto.batteryType);
//            }
//            if (remoteControllerDto.name != null) {
//                fetchedRemoteContoller.setName(remoteControllerDto.name);
//            }
//            if (remoteControllerDto.brand != null) {
//                fetchedRemoteContoller.setBrand(remoteControllerDto.brand);
//            }
//            if (remoteControllerDto.price != null) {
//                fetchedRemoteContoller.setPrice(remoteControllerDto.price);
//            }
//            //TODO: what if cliënt wants to make it zero? modify.
//            if (remoteControllerDto.originalStock != 0) {
//                fetchedRemoteContoller.setOriginalStock(remoteControllerDto.originalStock);
//            }
//
//            remoteControllerRepository.save(fetchedRemoteContoller);
//            DtoConverters.remoteControllerDtoConverter(remoteControllerRepository.findById(id).get(), remoteControllerDto);
//
//            return remoteControllerDto;
//
//        } else {
//            throw new RecordNotFoundException("We hebben geen afstandsbediening met dit ID.");
//        }
//    }
//
//
//    ///// For deleting remote controller from database /////
//    public String deleteRemoteController(Long id) {
//        if (remoteControllerRepository.existsById(id)) {
//            remoteControllerRepository.deleteAllById(Collections.singleton(id));
//
//            return "We hebben afstandsbediening met id: " + id + " uit de database verwijderd.";
//        } else {
//            throw new RecordNotFoundException("We hebben geen afstandsbediening met dit ID.");
//        }
//    }
}
