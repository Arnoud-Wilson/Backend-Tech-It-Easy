package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.models.Television;
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
    //:TODO: make this a DTO or rather only the id!
    public TelevisionDto televisionDto;

}
