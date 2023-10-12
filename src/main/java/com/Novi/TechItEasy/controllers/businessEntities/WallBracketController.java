package com.Novi.TechItEasy.controllers.businessEntities;

import com.Novi.TechItEasy.dtos.businessEntities.WallBracketDto;
import com.Novi.TechItEasy.dtos.businessEntities.WallBracketInputDto;
import com.Novi.TechItEasy.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallBrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getWallBrackets() {

        return ResponseEntity.ok(wallBracketService.getWallBrackets());
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {

        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }


    @PostMapping
    public ResponseEntity<Object> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracket, BindingResult bindingResult) {

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

            WallBracketDto dto = wallBracketService.createWallBracket(wallBracket);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.id).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<Object> changeWallBracket(@PathVariable Long id,@Valid @RequestBody WallBracketDto wallBracket, BindingResult bindingResult) {

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
            return ResponseEntity.ok(wallBracketService.changeWallBracket(id, wallBracket));
        }
    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {

        return ResponseEntity.ok(wallBracketService.deleteWallBracket(id));
    }
}
