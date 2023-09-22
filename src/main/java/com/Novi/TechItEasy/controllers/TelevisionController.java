package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.IdInputDto;
import com.Novi.TechItEasy.dtos.TelevisionDto;
import com.Novi.TechItEasy.dtos.TelevisionInputDto;
import com.Novi.TechItEasy.exceptions.MinimalRequiredTelevisionException;
import com.Novi.TechItEasy.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getTelevisions() {

        return ResponseEntity.ok(televisionService.getTelevisions());
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {

        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

      
    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@RequestBody TelevisionInputDto television) {

        if (television.getBrand() == null || television.getName() == null) {
            throw new MinimalRequiredTelevisionException();
        } else {

            TelevisionDto dto = televisionService.addTelevision(television);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.getId()).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<TelevisionDto> changeTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto television) {

            return ResponseEntity.ok(televisionService.changeTelevision(id, television));
    }

    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<Object> assignRemoteControllerToTelevision(@PathVariable Long id, @Valid @RequestBody IdInputDto remoteId, BindingResult bindingResult) {

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

            TelevisionDto dto = televisionService.assignRemoteControllerToTelevision(id, remoteId);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.getId()).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }

    @PutMapping("/{id}/cimodule")
    public ResponseEntity<Object> assignCiModuleToTelevision(@PathVariable Long id, @Valid @RequestBody IdInputDto CiModuleId, BindingResult bindingResult) {

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

            TelevisionDto dto = televisionService.assignCiModuleToTelevision(id, CiModuleId);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.getId()).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }

    @PutMapping("/{id}/wallbracket")
    public ResponseEntity<Object> assignWallBracketToTelevision(@PathVariable Long id, @Valid @RequestBody IdInputDto wallBracketId, BindingResult bindingResult) {

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

            TelevisionDto dto = televisionService.assignWallBracketToTelevision(id, wallBracketId);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.getId()).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id) {

            return ResponseEntity.ok(televisionService.deleteTelevision(id));
    }
}
