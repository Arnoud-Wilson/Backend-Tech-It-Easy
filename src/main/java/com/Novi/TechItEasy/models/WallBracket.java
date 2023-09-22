package com.Novi.TechItEasy.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "wallBrackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "adjustable")
    private Boolean adjustable;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "wallBracketList")
    private List<Television> televisionList;



    public Long getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Television> getTelevisionList() {
        return televisionList;
    }

    public void setTelevisionList(List<Television> televisionList) {
        this.televisionList = televisionList;
    }
}
