package com.Novi.TechItEasy.dtos.businessEntities;

import jakarta.validation.constraints.Max;

public class RemoteControllerDto {

    public Long id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    @Max(500)
    public Double price;
    public int originalStock;

    public TelevisionDto televisionDto;

}
