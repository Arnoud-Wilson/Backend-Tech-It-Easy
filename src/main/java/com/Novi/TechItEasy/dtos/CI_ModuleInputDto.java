package com.Novi.TechItEasy.dtos;

import jakarta.validation.constraints.NotBlank;

public class CI_ModuleInputDto {

    @NotBlank
    public String name;
    public String type;
    public Double price;
}
