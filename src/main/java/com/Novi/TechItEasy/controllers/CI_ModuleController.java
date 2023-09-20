package com.Novi.TechItEasy.controllers;

import com.Novi.TechItEasy.dtos.CI_ModuleDto;
import com.Novi.TechItEasy.dtos.WallBracketDto;
import com.Novi.TechItEasy.services.CI_ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ci_modules")
public class CI_ModuleController {

    private final CI_ModuleService ci_moduleService;

    public CI_ModuleController(CI_ModuleService ci_moduleService) {
        this.ci_moduleService = ci_moduleService;
    }


    @GetMapping
    public ResponseEntity<List<CI_ModuleDto>> getCiModules() {

        return ResponseEntity.ok(ci_moduleService.getCiModules());
    }

//
//    @GetMapping(value ="/{id}")
//    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {
//
//        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
//    }
//
//
//    @PostMapping
//    public ResponseEntity<Object> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracket, BindingResult bindingResult) {
//
//        if (bindingResult.hasFieldErrors()) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                stringBuilder.append(fieldError.getField());
//                stringBuilder.append(": ");
//                stringBuilder.append(fieldError.getDefaultMessage());
//                stringBuilder.append("\n");
//            }
//            return ResponseEntity.badRequest().body(stringBuilder);
//        } else {
//
//            WallBracketDto dto = wallBracketService.createWallBracket(wallBracket);
//            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.id).toUriString());
//
//            return ResponseEntity.created(uri).body(dto);
//        }
//    }
//
//
//    @PutMapping(value ="/{id}")
//    public ResponseEntity<WallBracketDto> changeWallBracket(@PathVariable Long id, @RequestBody WallBracketDto wallBracket) {
//
//        return ResponseEntity.ok(wallBracketService.changeWallBracket(id, wallBracket));
//    }
//
//
//    @DeleteMapping(value ="/{id}")
//    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
//
//        return ResponseEntity.ok(wallBracketService.deleteWallBracket(id));
//    }
}
