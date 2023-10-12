package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.businessEntities.RemoteControllerDto;
import com.Novi.TechItEasy.dtos.businessEntities.RemoteControllerInputDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.businessEntities.RemoteController;
import com.Novi.TechItEasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }


    /// For fetching all remote controllers currently in the database /////
    public List<RemoteControllerDto> getRemoteControllers() {

        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerDto> remoteControllerDtos = new ArrayList<>();

        for (RemoteController remoteController : remoteControllers) {
            RemoteControllerDto dto = new RemoteControllerDto();
            DtoConverters.remoteControllerDtoConverter(remoteController, dto);
            remoteControllerDtos.add(dto);
        }

        if (remoteControllerDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen afstandsbedieningen om te laten zien");
        } else {
            return remoteControllerDtos;
        }
    }


    /// For fetching one remote controller by id /////
    public RemoteControllerDto getRemoteController(Long id) {
        Optional<RemoteController> fetchedRemoteController = remoteControllerRepository.findById(id);

        if (fetchedRemoteController.isPresent()) {
            RemoteControllerDto dto = new RemoteControllerDto();
            DtoConverters.remoteControllerDtoConverter(fetchedRemoteController.get(), dto);
            return dto;

        } else {
            throw new RecordNotFoundException("We hebben geen afstandsbediening met id: " + id + " in onze database.");
        }
    }


    /// For creating one new remote controller in database /////
    public RemoteControllerDto createRemoteController(RemoteControllerInputDto remoteController) {

        RemoteController newRemoteController = new RemoteController();
        DtoConverters.remoteControllerInputDtoConverter(newRemoteController, remoteController);

        remoteControllerRepository.save(newRemoteController);

        RemoteControllerDto dto = new RemoteControllerDto();
        DtoConverters.remoteControllerDtoConverter(newRemoteController, dto);


        return dto;
    }


    ///// For changing remote controller in database /////
    public RemoteControllerDto changeRemoteController(Long id, RemoteControllerDto remoteControllerDto) {

        Optional<RemoteController> databaseRemoteContoller = remoteControllerRepository.findById(id);

        if (databaseRemoteContoller.isPresent()) {
            RemoteController fetchedRemoteContoller = databaseRemoteContoller.get();

            if (remoteControllerDto.compatibleWith != null) {
                fetchedRemoteContoller.setCompatibleWith(remoteControllerDto.compatibleWith);
            }
            if (remoteControllerDto.batteryType != null) {
                fetchedRemoteContoller.setBatteryType(remoteControllerDto.batteryType);
            }
            if (remoteControllerDto.name != null) {
                fetchedRemoteContoller.setName(remoteControllerDto.name);
            }
            if (remoteControllerDto.brand != null) {
                fetchedRemoteContoller.setBrand(remoteControllerDto.brand);
            }
            if (remoteControllerDto.price != null) {
                fetchedRemoteContoller.setPrice(remoteControllerDto.price);
            }
            //TODO: what if cliënt wants to make it zero? modify.
            if (remoteControllerDto.originalStock != 0) {
                fetchedRemoteContoller.setOriginalStock(remoteControllerDto.originalStock);
            }

            remoteControllerRepository.save(fetchedRemoteContoller);
            DtoConverters.remoteControllerDtoConverter(remoteControllerRepository.findById(id).get(), remoteControllerDto);

            return remoteControllerDto;

        } else {
            throw new RecordNotFoundException("We hebben geen afstandsbediening met id: " + id + " in onze database.");
        }
    }


    ///// For deleting remote controller from database /////
    public String deleteRemoteController(Long id) {
        if (remoteControllerRepository.existsById(id)) {
            remoteControllerRepository.deleteAllById(Collections.singleton(id));

            return "We hebben afstandsbediening met id: " + id + " uit de database verwijderd.";
        } else {
            throw new RecordNotFoundException("We hebben geen afstandsbediening met id: " + id + " in onze database.");
        }
    }
}
