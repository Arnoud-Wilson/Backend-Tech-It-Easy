package com.Novi.TechItEasy.models;

import com.Novi.TechItEasy.dtos.WallBracketDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "television")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
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

    @JsonIgnore
    @OneToOne
    private RemoteController remoteController;

    @JsonIgnore
    @ManyToOne
    private CiModule ciModule;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "television_wallbracket_list")
    @JoinColumn(name = "wallbracket_id")
    private List<WallBracket> wallBracketList;




    public Long getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return this.availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return this.refreshRate;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return this.screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return this.smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return this.wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return this.voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return this.hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return this.bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return this.ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return this.originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return this.sold;
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

    public CiModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModule ciModule) {
        this.ciModule = ciModule;
    }

    public List<WallBracket> getWallBracketList() {
        return wallBracketList;
    }

    public void setWallBracketList(List<WallBracket> wallBracketList) {
        this.wallBracketList = wallBracketList;
    }


    @Override
    public String toString() {
        return "Television{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availableSize=" + availableSize +
                ", refreshRate=" + refreshRate +
                ", screenType='" + screenType + '\'' +
                ", screenQuality='" + screenQuality + '\'' +
                ", smartTv=" + smartTv +
                ", wifi=" + wifi +
                ", voiceControl=" + voiceControl +
                ", hdr=" + hdr +
                ", bluetooth=" + bluetooth +
                ", ambiLight=" + ambiLight +
                ", originalStock=" + originalStock +
                ", sold=" + sold +
                '}';
    }

}
