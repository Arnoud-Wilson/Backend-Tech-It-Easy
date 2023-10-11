package com.Novi.TechItEasy.controllers.mapping;

import com.Novi.TechItEasy.dtos.entity.CI_ModuleDto;
import com.Novi.TechItEasy.dtos.entity.CI_ModuleInputDto;
import com.Novi.TechItEasy.services.CI_ModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @GetMapping(value ="/{id}")
    public ResponseEntity<CI_ModuleDto> getCiModule(@PathVariable Long id) {

        return ResponseEntity.ok(ci_moduleService.getCiModule(id));
    }


    @PostMapping
    public ResponseEntity<Object> createCiModule(@Valid @RequestBody CI_ModuleInputDto ci_module, BindingResult bindingResult) {

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

            CI_ModuleDto dto = ci_moduleService.createCiModule(ci_module);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + dto.id).toUriString());

            return ResponseEntity.created(uri).body(dto);
        }
    }


    @PutMapping(value ="/{id}")
    public ResponseEntity<CI_ModuleDto> changeCiModule(@PathVariable Long id, @RequestBody CI_ModuleDto ci_module) {

        return ResponseEntity.ok(ci_moduleService.changeCiModule(id, ci_module));
    }


    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> deleteCiModule(@PathVariable Long id) {

        return ResponseEntity.ok(ci_moduleService.deleteCiModule(id));
    }
}
