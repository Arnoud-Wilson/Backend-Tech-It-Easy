package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.models.Television;
import jakarta.validation.constraints.Max;

import java.util.List;

public class WallBracketDto {

    public Long id;
    public String size;
    public Boolean adjustable;
    public String name;
    @Max(500)
    public Double price;
    public List<TelevisionDto> televisionDtoList;

}
