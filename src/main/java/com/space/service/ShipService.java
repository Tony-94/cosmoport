package com.space.service;

import com.space.controller.ShipOrder;
import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;

public interface ShipService {

    Ship getShip(Long id);

    void deleteShip(Long id);

    List<Ship> getAll(String name, String planet, ShipType shipType, Long after, Long before, Boolean isUsed,
                      Double minSpeed, Double maxSpeed, Integer minCrewSize, Integer maxCrewSize,
                      Double minRating, Double maxRating, ShipOrder shipOrder, Integer pageNumber, Integer pageSize);

    Ship updateShip(Long id, Ship ship);

    Ship createShip(Ship ship);

    Ship getShipList(String name, String planet, ShipType shipType, Long after, Long before, Boolean isUsed,
                     Double minSpeed, Double maxSpeed, Integer minCrewSize, Integer maxCrewSize,
                     Double minRating, Double maxRating, ShipOrder order, Integer pageNumber, Integer pageSize);

    Integer getShipCount(String name, String planet, ShipType shipType, Long after, Long before, Boolean isUsed,
                      Double minSpeed, Double maxSpeed, Integer minCrewSize, Integer maxCrewSize,
                      Double minRating, Double maxRating);


}
