package com.Novi.TechItEasy.dtos.businessEntities;

import jakarta.validation.constraints.Max;


import java.util.List;

public class CiModuleDto {

    public Long id;
    public String name;
    public String type;
    @Max(1000)
    public Double price;

    public List<TelevisionDto> televisionDtoList;
}
