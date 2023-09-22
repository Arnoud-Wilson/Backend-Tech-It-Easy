package com.Novi.TechItEasy.services;

import com.Novi.TechItEasy.dtos.IdInputDto;
import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.dtos.TelevisionInputDto;
import com.Novi.TechItEasy.exceptions.RecordNotFoundException;
import com.Novi.TechItEasy.models.CI_Module;
import com.Novi.TechItEasy.models.RemoteController;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.repositories.CI_ModuleRepository;
import com.Novi.TechItEasy.repositories.RemoteControllerRepository;
import com.Novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CI_ModuleRepository ci_moduleRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, CI_ModuleRepository ci_moduleRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ci_moduleRepository = ci_moduleRepository;
    }


    /// For fetching all televisions currently in the database /////
    public List<TelevisionDto> getTelevisions() {

        List<Television> televisions = new ArrayList<>(televisionRepository.findAll());
        List<TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions) {
            TelevisionDto dto = TelevisionDto.fromTelevision(television);
            televisionDtos.add(dto);
        }

        if (televisionDtos.isEmpty()) {
            throw new RecordNotFoundException("We hebben geen televisies om te laten zien");
        } else {
            return televisionDtos;
        }
    }


    /// For fetching one television by id /////
    public TelevisionDto getTelevision(Long id) {
        Optional<Television> fetchedTelevision = televisionRepository.findById(id);

        if (fetchedTelevision.isPresent()) {
            TelevisionDto dto = TelevisionDto.fromTelevision(fetchedTelevision.get());
            return dto;
        } else {
            throw new RecordNotFoundException("We hebben geen televisie met dit ID.");
        }
    }


    /// For creating one new television in database /////
    public TelevisionDto addTelevision(@RequestBody TelevisionInputDto television) {

        Television inputTelevision = television.toTelevision();

        televisionRepository.save(inputTelevision);

        TelevisionDto dto = TelevisionDto.fromTelevision(inputTelevision);


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + inputTelevision.getId()).toUriString());

        //TODO: return and use uri location
        return dto;
    }


    ///// For changing television in database /////
    public TelevisionDto changeTelevision(Long id, TelevisionInputDto television) {

        Optional<Television> databaseTelevision = televisionRepository.findById(id);

        if (databaseTelevision.isPresent()) {
            Television fetchedTelevision = databaseTelevision.get();

            if (television.getBrand() != null) {
                fetchedTelevision.setBrand(television.getBrand());
            }
            if (television.getName() != null) {
                fetchedTelevision.setName(television.getName());
            }
            if (television.getType() != null) {
                fetchedTelevision.setType(television.getType());
            }
            if (television.getPrice() != null) {
                fetchedTelevision.setPrice(television.getPrice());
            }
            if (television.getAvailableSize() != null) {
                fetchedTelevision.setAvailableSize(television.getAvailableSize());
            }
            if (television.getRefreshRate() != null) {
                fetchedTelevision.setRefreshRate(television.getRefreshRate());
            }
            if (television.getScreenType() != null) {
                fetchedTelevision.setScreenType(television.getScreenType());
            }
            if (television.getScreenQuality() != null) {
                fetchedTelevision.setScreenQuality(television.getScreenQuality());
            }
            if (television.getSmartTv() != null) {
                fetchedTelevision.setSmartTv(television.getSmartTv());
            }
            if (television.getWifi() != null) {
                fetchedTelevision.setWifi(television.getWifi());
            }
            if (television.getVoiceControl() != null) {
                fetchedTelevision.setVoiceControl(television.getVoiceControl());
            }
            if (television.getHdr() != null) {
                fetchedTelevision.setHdr(television.getHdr());
            }
            if (television.getBluetooth() != null) {
                fetchedTelevision.setBluetooth(television.getBluetooth());
            }
            if (television.getAmbiLight() != null) {
                fetchedTelevision.setAmbiLight(television.getAmbiLight());
            }
            //TODO: what if cliënt wants to make it zero? modify.
            if (television.getOriginalStock() != 0) {
                fetchedTelevision.setOriginalStock(television.getOriginalStock());
            }
            if (television.getSold() != 0) {
                fetchedTelevision.setSold(television.getSold());
            }

            televisionRepository.save(fetchedTelevision);

            return TelevisionDto.fromTelevision(televisionRepository.findById(id).get());

        } else {
            throw new RecordNotFoundException("We hebben geen televisie met dit ID.");
        }
    }


    ///// For assigning remote controllers to television by id /////
    public TelevisionDto assignRemoteControllerToTelevision(Long televisionId, IdInputDto remoteId) {
        Optional<Television> fetchedTelevision =  televisionRepository.findById(televisionId);
        Optional<RemoteController> fetchedRemoteController = remoteControllerRepository.findById(remoteId.id);

        if (fetchedTelevision.isPresent()) {
            if (fetchedRemoteController.isPresent()) {

                fetchedTelevision.get().setRemoteController(fetchedRemoteController.get());

                televisionRepository.save(fetchedTelevision.get());
                fetchedRemoteController.get().setTelevision(fetchedTelevision.get());

                return TelevisionDto.fromTelevision(televisionRepository.findById(televisionId).get());
            } else {
                throw new RecordNotFoundException("We hebben geen afstandsbediening met ID: " + remoteId.id + ".");
            }
        } else {
            throw new RecordNotFoundException("We hebben geen televisie met ID: " + televisionId + ".");
        }
    }

    ///// For assigning CI module to television by id /////
    public TelevisionDto assignCiModuleToTelevision(Long televisionId, IdInputDto ciModuleId) {
        Optional<Television> fetchedTelevision =  televisionRepository.findById(televisionId);
        Optional<CI_Module> fetchedCiModule = ci_moduleRepository.findById(ciModuleId.id);

        if (fetchedTelevision.isPresent()) {
            if (fetchedCiModule.isPresent()) {
                // alle nu bekende televisies van ci module //
                List<Television> ciModuleTelevisionList = fetchedCiModule.get().getTelevisionList();

                // ci module aan televisie toevoegen en opslaan //
                fetchedTelevision.get().setCi_module(fetchedCiModule.get());
                televisionRepository.save(fetchedTelevision.get());

                // televisie aan de lijst van televisies van ci module toevoegen //
                ciModuleTelevisionList.add(fetchedTelevision.get());

                // ge-update lijst van televisies in ci module opslaan //
                fetchedCiModule.get().setTelevisionList(ciModuleTelevisionList);
                ci_moduleRepository.save(fetchedCiModule.get());

                return TelevisionDto.fromTelevision(televisionRepository.findById(televisionId).get());
            } else {
                throw new RecordNotFoundException("We hebben geen CI module met ID: " + ciModuleId.id + ".");
            }
        } else {
            throw new RecordNotFoundException("We hebben geen televisie met ID: " + televisionId + ".");
        }
    }


    ///// For deleting television from database /////
    public String deleteTelevision(Long id) {
        if (televisionRepository.existsById(id)) {
            televisionRepository.deleteAllById(Collections.singleton(id));

            return "We hebben televisie met id: " + id + " uit de database verwijderd.";
        } else {
            throw new RecordNotFoundException("We hebben geen televisie met dit ID.");
        }
    }
}
