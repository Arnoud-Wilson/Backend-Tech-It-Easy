package com.Novi.TechItEasy.dtos.entity;

import com.Novi.TechItEasy.models.entity.Television;

import java.util.List;

public class CI_ModuleDto {

    public Long id;
    public String name;
    public String type;
    public Double price;
    public List<Television> televisionList;
}