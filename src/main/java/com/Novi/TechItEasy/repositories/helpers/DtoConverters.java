package com.Novi.TechItEasy.repositories.helpers;

import com.Novi.TechItEasy.dtos.entity.*;
import com.Novi.TechItEasy.models.entity.CI_Module;
import com.Novi.TechItEasy.models.entity.RemoteController;
import com.Novi.TechItEasy.models.entity.WallBracket;

public class DtoConverters {

    public static void remoteControllerDtoConverter(RemoteController remoteController, RemoteControllerDto dto) {

        dto.id = remoteController.getId();
        dto.compatibleWith = remoteController.getCompatibleWith();
        dto.batteryType = remoteController.getBatteryType();
        dto.name = remoteController.getName();
        dto.brand = remoteController.getBrand();
        dto.price = remoteController.getPrice();
        dto.originalStock = remoteController.getOriginalStock();
        dto.television = remoteController.getTelevision();

    }

    public static void remoteControllerInputDtoConverter(RemoteController remoteController, RemoteControllerInputDto dto) {

        remoteController.setCompatibleWith(dto.compatibleWith);
        remoteController.setBatteryType(dto.batteryType);
        remoteController.setName(dto.name);
        remoteController.setBrand(dto.brand);
        remoteController.setPrice(dto.price);
        remoteController.setOriginalStock(dto.originalStock);
    }

    public static void wallBracketDtoConverter(WallBracket wallBracket, WallBracketDto dto) {

        dto.id = wallBracket.getId();
        dto.size = wallBracket.getSize();
        dto.adjustable = wallBracket.getAdjustable();
        dto.name = wallBracket.getName();
        dto.price = wallBracket.getPrice();
        dto.televisionList = wallBracket.getTelevisionList();
    }

    public static void wallBracketInputDtoConverter(WallBracket wallBracket, WallBracketInputDto dto) {

        wallBracket.setSize(dto.size);
        wallBracket.setAdjustable(dto.adjustable);
        wallBracket.setName(dto.name);
        wallBracket.setPrice(dto.price);
    }

    public static void CI_ModuleDtoConverter(CI_Module ci_module, CI_ModuleDto dto) {

        dto.id = ci_module.getId();
        dto.name = ci_module.getName();
        dto.type = ci_module.getType();
        dto.price = ci_module.getPrice();
        dto.televisionList = ci_module.getTelevisionList();
    }

    public static void CI_ModuleInputDtoConverter(CI_Module ci_module, CI_ModuleInputDto dto) {

        ci_module.setName(dto.name);
        ci_module.setType(dto.type);
        ci_module.setPrice(dto.price);
    }
}
