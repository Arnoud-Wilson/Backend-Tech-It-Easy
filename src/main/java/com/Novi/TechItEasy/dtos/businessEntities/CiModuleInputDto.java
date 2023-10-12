package com.Novi.TechItEasy.dtos.businessEntities;

import jakarta.validation.constraints.NotBlank;

public class CiModuleInputDto {

    @NotBlank
    public String name;
    public String type;
    public Double price;
}
