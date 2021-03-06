package com.space.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id корабля

    @Column(name = "name")
    private String name; // название корабля до 50 знаков включительно

    @Column(name = "planet")
    private String planet; // планета пребывания до 50 знаков включительно

    @Column(name = "shipType")
    @Enumerated(EnumType.STRING)
    private ShipType shipType; //тип корабля

    @Column(name = "prodDate")
    private Date prodDate; //дата выпуска(диапазон значений года 2800..3019 включительно

    @Column(name = "isUsed")
    private Boolean isUsed; //использованный/новый

    @Column(name = "speed")
    private Double speed; // Максимальная скорость корабля. Диапазон значений 0,01..0,99 включительно. Используй математическое округление до сотых.

    @Column(name = "crewSize")
    private Integer crewSize; //Количество членов экипажа. Диапазон значений 1..9999 включительно.

    @Column(name = "rating")
    private Double rating; //Рейтинг корабля. Используй математическое округление до сотых.


    public Ship() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
