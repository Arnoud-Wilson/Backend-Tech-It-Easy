package com.Novi.TechItEasy.dtos;

import com.Novi.TechItEasy.models.Television;

public class TelevisionInputDto {

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


    public Television toTelevision() {

        Television television = new Television();

        television.setId(this.id);
        television.setBrand(this.brand);
        television.setName(this.name);
        television.setType(this.type);
        television.setPrice(this.price);
        television.setAvailableSize(this.availableSize);
        television.setRefreshRate(this.refreshRate);
        television.setScreenType(this.screenType);
        television.setScreenQuality(this.screenQuality);
        television.setSmartTv(this.smartTv);
        television.setWifi(this.wifi);
        television.setVoiceControl(this.voiceControl);
        television.setHdr(this.hdr);
        television.setBluetooth(this.bluetooth);
        television.setAmbiLight(this.ambiLight);
        television.setOriginalStock(this.originalStock);
        television.setSold(this.sold);

        return television;
    }
}
