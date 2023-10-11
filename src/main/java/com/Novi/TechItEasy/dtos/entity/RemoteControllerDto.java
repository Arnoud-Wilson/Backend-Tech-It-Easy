package com.Novi.TechItEasy.dtos.entity;

import com.Novi.TechItEasy.models.entity.Television;

public class RemoteControllerDto {

    public Long id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public int originalStock;
    //:TODO: make this a DTO?
    public Television television;

}
