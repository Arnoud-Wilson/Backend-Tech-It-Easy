package com.Novi.TechItEasy.helpers;

import com.Novi.TechItEasy.dtos.RemoteControllerDto;
import com.Novi.TechItEasy.dtos.RemoteControllerInputDto;
import com.Novi.TechItEasy.dtos.WallBracketDto;
import com.Novi.TechItEasy.dtos.WallBracketInputDto;
import com.Novi.TechItEasy.models.RemoteController;
import com.Novi.TechItEasy.models.WallBracket;

public class DtoConverters {

    public static void remoteControllerDtoConverter(RemoteController remoteController, RemoteControllerDto dto) {

        dto.id = remoteController.getId();
        dto.compatibleWith = remoteController.getCompatibleWith();
        dto.batteryType = remoteController.getBatteryType();
        dto.name = remoteController.getName();
        dto.brand = remoteController.getBrand();
        dto.price = remoteController.getPrice();
        dto.originalStock = remoteController.getOriginalStock();

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
    }

    public static void wallBracketInputDtoConverter(WallBracket wallBracket, WallBracketInputDto dto) {

        wallBracket.setSize(dto.size);
        wallBracket.setAdjustable(dto.adjustable);
        wallBracket.setName(dto.name);
        wallBracket.setPrice(dto.price);
    }
}