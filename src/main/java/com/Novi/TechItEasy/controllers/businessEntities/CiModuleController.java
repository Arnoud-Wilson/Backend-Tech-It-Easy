package com.Novi.TechItEasy.controllers.businessEntities;

import com.Novi.TechItEasy.dtos.CiModuleDto;
import com.Novi.TechItEasy.dtos.CiModuleInputDto;
import com.Novi.TechItEasy.services.CiModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/cimodules")
public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }


    @GetMapping
    public ResponseEntity<List<CiModuleDto>> getCiModules() {

        return ResponseEntity.ok(ciModuleService.getCiModules());
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {

        return ResponseEntity.ok(ciModuleService.getCiModule(id));
    }


    @PostMapping
    public ResponseEntity<Object> createCiModule(@Valid @RequestBody CiModuleInputDto ci_module, BindingResult bindingResult) {

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

            CiModuleDto dto = ciModuleService.createCiModule(ci_module);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.id).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<Object> changeCiModule(@PathVariable Long id,@Valid @RequestBody CiModuleDto ci_module, BindingResult bindingResult) {


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
            return ResponseEntity.ok(ciModuleService.changeCiModule(id, ci_module));
        }
    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteCiModule(@PathVariable Long id) {

        return ResponseEntity.ok(ciModuleService.deleteCiModule(id));
    }
}
