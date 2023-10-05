package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.RemoteControllerDto;
import com.Novi.TechItEasy.dtos.RemoteControllerInputDto;
import com.Novi.TechItEasy.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
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
    public ResponseEntity<Object> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteController, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                stringBuilder.append(fieldError.getField());
                stringBuilder.append(": ");
                stringBuilder.append(fieldError.getDefaultMessage());
                stringBuilder.append("\n");
            }
            return ResponseEntity.badRequest().body(stringBuilder);
        } else {

            RemoteControllerDto dto = remoteControllerService.createRemoteController(remoteController);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.id).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<Object> changeRemoteController(@PathVariable Long id,@Valid @RequestBody RemoteControllerDto remoteController, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                stringBuilder.append(fieldError.getField());
                stringBuilder.append(": ");
                stringBuilder.append(fieldError.getDefaultMessage());
                stringBuilder.append("\n");
            }
            return ResponseEntity.badRequest().body(stringBuilder);
        } else {
            return ResponseEntity.ok(remoteControllerService.changeRemoteController(id, remoteController));
        }
    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {

        return ResponseEntity.ok(remoteControllerService.deleteRemoteController(id));
    }
}
