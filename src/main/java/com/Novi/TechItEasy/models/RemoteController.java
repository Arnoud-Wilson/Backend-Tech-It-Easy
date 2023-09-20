package com.Novi.TechItEasy.models;

import jakarta.persistence.*;

    @Entity
    @Table(name= "RemoteControllers")
    public class RemoteController {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        private Long id;
        @Column(name = "compatibleWith",nullable = false)
        private String compatibleWith;
        @Column(name = "batteryType")
        private String batteryType;
        @Column(name = "name", nullable = false)
        private String name;
        @Column(name = "brand", nullable = false)
        private String brand;
        @Column(name = "price")
        private Double price;
        @Column(name = "originalStock")
        private int originalStock;



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
}
