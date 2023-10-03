package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.models.CiModule;
import com.Novi.TechItEasy.models.RemoteController;
import com.Novi.TechItEasy.models.Television;
import com.Novi.TechItEasy.models.WallBracket;

import java.util.List;

public class TelevisionDto {


    private Long id;
    private String brand;
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
    //TODO: make this a dto?
    private RemoteController remoteController;
    private CiModule ciModule;

    private List<WallBracket> wallBracketList;


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
        dto.remoteController = television.getRemoteController();
        dto.ciModule = television.getCiModule();
        dto.wallBracketList = television.getWallBracketList();

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

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public CiModule getCi_module() {
        return ciModule;
    }

    public void setCi_module(CiModule ci_module) {
        this.ciModule = ciModule;
    }

    public List<WallBracket> getWallBracketList() {
        return wallBracketList;
    }

    public void setWallBracketList(List<WallBracket> wallBracketList) {
        this.wallBracketList = wallBracketList;
    }
}
