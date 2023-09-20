package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.RemoteControllerDto;
import com.Novi.TechItEasy.dtos.RemoteControllerInputDto;
import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.RemoteController;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.RemoteControllerRepository;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

//TODO: ombouwen naar remote controller
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }


    /// For fetching all remote controllers currently in the database /////
    public List<RemoteControllerDto> getRemoteControllers() {

        List<RemoteController> remoteControllers = new ArrayList<>(remoteControllerRepository.findAll());
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
            throw new RecordNotFoundException("We hebben geen afstandsbediening met dit ID.");
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
            throw new RecordNotFoundException("We hebben geen afstandsbediening met dit ID.");
        }
    }

//
//    ///// For deleting television from database /////
//    public String deleteTelevision(Long id) {
//        if (televisionRepository.existsById(id)) {
//            televisionRepository.deleteAllById(Collections.singleton(id));
//
//            return "We hebben televisie met id: " + id + " uit de database verwijderd.";
//        } else {
//            throw new RecordNotFoundException("We hebben geen televisie met dit ID.");
//        }
//    }
}
