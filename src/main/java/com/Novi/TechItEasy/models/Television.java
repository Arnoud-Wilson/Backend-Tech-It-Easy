package com.Novi.TechItEasy.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import java.util.Optional;


@Entity
@Table(name = "television")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private Double price;
    @Column(name = "availableSize")
    private Double availableSize;
    @Column(name = "refreshRate")
    private Double refreshRate;
    @Column(name = "screenType")
    private String screenType;
    @Column(name = "screenQuality")
    private String screenQuality;
    @Column(name = "smartTv")
    private Boolean smartTv;
    @Column(name = "wifi")
    private Boolean wifi;
    @Column(name = "voiceControl")
    private Boolean voiceControl;
    @Column(name = "hdr")
    private Boolean hdr;
    @Column(name = "bluetooth")
    private Boolean bluetooth;
    @Column(name = "ambiLight")
    private Boolean ambiLight;
    @Column(name = "originalStock")
    private int originalStock;
    @Column(name = "sold")
    private int sold;

    //Don't know why butt without @JsonIgnore there's an error when fetching television whit foreign remote controller key in it//
    @JsonIgnore
    @OneToOne
    private RemoteController remoteController;

    @JsonIgnore
    @ManyToOne
    private CI_Module ci_module;




    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CI_Module getCi_module() {
        return ci_module;
    }

    public void setCi_module(CI_Module ci_module) {
        this.ci_module = ci_module;
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
