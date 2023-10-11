package com.Novi.TechItEasy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

    @Entity
    @Table(name= "RemoteControllers")
    public class RemoteController {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false)
        private Long id;
        @Column(nullable = false)
        private String compatibleWith;
        private String batteryType;
        @Column(nullable = false)
        private String name;
        @Column(nullable = false)
        private String brand;
        private Double price;
        private int originalStock;
        @JsonIgnore
        @OneToOne(mappedBy = "remoteController")
        private Television television;



        public Long getId() {
            return id;
        }

        public String getCompatibleWith() {
            return compatibleWith;
        }

        public void setCompatibleWith(String compatibleWith) {
            this.compatibleWith = compatibleWith;
        }

        public String getBatteryType() {
            return batteryType;
        }

        public void setBatteryType(String batteryType) {
            this.batteryType = batteryType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public int getOriginalStock() {
            return originalStock;
        }

        public void setOriginalStock(int originalStock) {
            this.originalStock = originalStock;
        }

        public Television getTelevision() {
            return television;
        }

        public void setTelevision(Television television) {
            this.television = television;
        }
    }
