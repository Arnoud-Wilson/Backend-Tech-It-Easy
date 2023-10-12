package com.Novi.TechItEasy.dtos.businessEntities;

import jakarta.validation.constraints.NotBlank;

public class RemoteControllerInputDto {

    @NotBlank
    public String compatibleWith;
    public String batteryType;
    @NotBlank
    public String name;
    @NotBlank
    public String brand;
    public Double price;
    public int originalStock;
}
