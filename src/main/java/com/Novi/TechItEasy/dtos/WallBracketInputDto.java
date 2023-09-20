package com.Novi.TechItEasy.dtos;

import jakarta.validation.constraints.NotBlank;

public class WallBracketInputDto {

    @NotBlank
    public String size;
    public Boolean adjustable;
    @NotBlank
    public String name;
    public Double price;
}
