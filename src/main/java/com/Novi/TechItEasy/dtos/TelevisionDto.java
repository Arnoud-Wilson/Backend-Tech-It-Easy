package com.Novi.TechItEasy.dtos;


import com.Novi.TechItEasy.models.Television;
import jakarta.validation.constraints.NotBlank;

public class TelevisionDto {

    @NotBlank
    private Long id;
    @NotBlank
    private String brand;
    @NotBlank
    private String name;
    private String type;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private int originalStock;
    private int sold;

    public static TelevisionDto fromTelevision(Television television) {

        TelevisionDto dto = new TelevisionDto();

        dto.id = television.getId();
        dto.brand = television.getBrand();
        dto.name = television.getName();
        dto.type = television.getType();
        dto.price = television.getPrice();
        dto.availableSize = television.getAvailableSize();
        dto.refreshRate = television.getRefreshRate();
        dto.screenType = television.getScreenType();
        dto.screenQuality = television.getScreenQuality();
        dto.smartTv = television.getSmartTv();
        dto.wifi = television.getWifi();
        dto.voiceControl = television.getVoiceControl();
        dto.hdr = television.getHdr();
        dto.bluetooth = television.getBluetooth();
        dto.ambiLight = television.getAmbiLight();
        dto.originalStock = television.getOriginalStock();
        dto.sold = television.getSold();

        return dto;
    }

}
