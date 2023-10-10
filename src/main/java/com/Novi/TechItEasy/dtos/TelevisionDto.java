package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.helpers.DtoConverters;
import com.Novi.TechItEasy.models.RemoteController;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.models.WallBracket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;

import java.util.ArrayList;
import java.util.List;

public class TelevisionDto {


    private Long id;
    private String brand;
    private String name;
    private String type;
    @Max(10000)
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

    private RemoteControllerDto remoteControllerDto;

    private CiModuleDto ciModuleDto;

    private List<WallBracketDto> wallBracketDtoList;


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
        boolean remoteFlag = false;
        boolean ciModuleFlag = false;
        boolean wallBracketFlag = false;

        if (television.getRemoteController() != null && !remoteFlag) {
            RemoteControllerDto convertRemoteDto = new RemoteControllerDto();
            remoteFlag = true;
            DtoConverters.remoteControllerDtoConverter(television.getRemoteController(), convertRemoteDto);
            remoteFlag = false;
            dto.remoteControllerDto = convertRemoteDto;
        }

        if (television.getCiModule() != null && !ciModuleFlag) {
            CiModuleDto convertCiDto = new CiModuleDto();
            ciModuleFlag = true;
            DtoConverters.CiModuleDtoConverter(television.getCiModule(), convertCiDto);
            ciModuleFlag = false;
            dto.ciModuleDto = convertCiDto;
        }

        if (television.getWallBracketList() !=null) {
            List<WallBracketDto> convertWallBracketDtoList = new ArrayList<>();
            List<WallBracket> wallBracketList = television.getWallBracketList();

            for (WallBracket wallBracket : wallBracketList) {
                WallBracketDto wallBracketDto = new WallBracketDto();
                wallBracketFlag = true;
                DtoConverters.wallBracketDtoConverter(wallBracket, wallBracketDto);
                wallBracketFlag = false;

                convertWallBracketDtoList.add(wallBracketDto);
            }

            dto.wallBracketDtoList = convertWallBracketDtoList;
        }

        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public RemoteControllerDto getRemoteControllerDto() {
        return remoteControllerDto;
    }

    public void setRemoteControllerDto(RemoteControllerDto remoteControllerDto) {
        this.remoteControllerDto = remoteControllerDto;
    }

    public CiModuleDto getCiModuleDto() {
        return ciModuleDto;
    }

    public void setCiModuleDto(CiModuleDto ciModuleDto) {
        this.ciModuleDto = ciModuleDto;
    }

    public List<WallBracketDto> getWallBracketDtoList() {
        return wallBracketDtoList;
    }

    public void setWallBracketDtoList(List<WallBracketDto> wallBracketDtoList) {
        this.wallBracketDtoList = wallBracketDtoList;
    }
}
