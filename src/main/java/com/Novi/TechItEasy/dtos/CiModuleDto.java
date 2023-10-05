package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.models.Television;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public class CiModuleDto {

    public Long id;
    public String name;
    public String type;
    @Max(1000)
    public Double price;
    public List<Television> televisionList;
}
