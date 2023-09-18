package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.RemoteControllerDto;
import com.Novi.TechItEasy.dtos.RemoteControllerInputDto;
import com.Novi.TechItEasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remoteControllers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getRemoteControllers() {

        return ResponseEntity.ok(remoteControllerService.getRemoteControllers());
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteController(@PathVariable Long id) {

        return ResponseEntity.ok(remoteControllerService.getRemoteController(id));
    }


    @PostMapping
    public ResponseEntity<RemoteControllerDto> addRemoteController(@RequestBody RemoteControllerInputDto remoteController) {

        //TODO @Valid + respons error + uri
            return ResponseEntity.created(null).body(remoteControllerService.addRemoteController(remoteController));
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<RemoteControllerDto> changeRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto remoteController) {

        return ResponseEntity.ok(remoteControllerService.changeRemoteController(id, remoteController));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {

        return ResponseEntity.ok(remoteControllerService.deleteRemoteController(id));
    }
}
