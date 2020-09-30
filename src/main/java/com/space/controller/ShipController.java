package com.space.controller;


import com.space.exception.BadRequestException;
import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ShipController {

    private ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }
    //прошел тесты
    @RequestMapping(value = "/ships/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ship> getShip(@PathVariable("id") Long id) {
        if (id == 0) {
            return new ResponseEntity<Ship>(HttpStatus.BAD_REQUEST);
        }

        Ship ship = shipService.getShip(id);

        if (ship == null) {
            return new ResponseEntity<Ship>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Ship>(ship, HttpStatus.OK);
    }



    //+++++++++++++++++
    @RequestMapping(value = "/ships/{id}", method = RequestMethod.POST)
    public Ship updateShip(@PathVariable("id")  String idParam, @RequestBody Ship ship) {
        Long id = validateAndGetLongId(idParam);
        ship.setId(id);
        return shipService.updateShip(id, ship);
    }


    //прошел тесты
    @RequestMapping(value = "/ships/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ship> deleteShip(@PathVariable("id") Long id) {
        if (id == 0) {
            return new ResponseEntity<Ship>(HttpStatus.BAD_REQUEST);
        }
        Ship ship = this.shipService.getShip(id);

        if (ship == null) {
            return new ResponseEntity<Ship>(HttpStatus.NOT_FOUND);
        }

        this.shipService.deleteShip(id);

        return new ResponseEntity<Ship>(HttpStatus.OK);
    }

    // нет методов createShip(), getShipCount(), getShipList()



    @RequestMapping(value = "/ships", method = RequestMethod.GET)
    public List<Ship> getAllShip(@RequestParam(value = "name", required = false) String name,
                                                 @RequestParam(value = "planet", required = false) String planet,
                                                 @RequestParam(value = "shipType", required = false) ShipType shipType,
                                                 @RequestParam(value = "after", required = false) Long after,
                                                 @RequestParam(value = "before", required = false) Long before,
                                                 @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                                 @RequestParam(value = "minSpeed", required = false) Double minSpeed,
                                                 @RequestParam(value = "maxSpeed", required = false) Double maxSpeed,
                                                 @RequestParam(value = "minCrewSize", required = false) Integer minCrewSize,
                                                 @RequestParam(value = "maxCrewSize", required = false) Integer maxCrewSize,
                                                 @RequestParam(value = "minRating", required = false) Double minRating,
                                                 @RequestParam(value = "maxRating", required = false) Double maxRating,
                                                 @RequestParam(value = "order", required = false, defaultValue = "ID") ShipOrder order,
                                                 @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize) {
        return shipService.getAll(name, planet, shipType, after, before, isUsed, minSpeed,
                maxSpeed, minCrewSize, maxCrewSize, minRating, maxRating, order, pageNumber, pageSize);
    }
    @RequestMapping(value = "/ships", method = RequestMethod.POST)
    public Ship createShip(@RequestBody Ship ship) {
        return shipService.createShip(ship);
    }

    private Long validateAndGetLongId(String idParam) {
        Long result = null;
        try {
            result = Long.parseLong(idParam);
        } catch (NumberFormatException e) {
            throw new BadRequestException(String.format("%s - is not valid id!", idParam));
        }
        if (result <= 0) {
            throw new BadRequestException(String.format("Id couldn't be less or equal to zero! Error while processing id: %s", idParam));
        }
        return result;
    }
    @RequestMapping(value = "/ships/count", method = RequestMethod.GET)
    public Integer getShipsCount(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "planet", required = false) String planet,
                                 @RequestParam(value = "shipType", required = false) ShipType shipType,
                                 @RequestParam(value = "after", required = false) Long after,
                                 @RequestParam(value = "before", required = false) Long before,
                                 @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                 @RequestParam(value = "minSpeed", required = false) Double minSpeed,
                                 @RequestParam(value = "maxSpeed", required = false) Double maxSpeed,
                                 @RequestParam(value = "minCrewSize", required = false) Integer minCrewSize,
                                 @RequestParam(value = "maxCrewSize", required = false) Integer maxCrewSize,
                                 @RequestParam(value = "minRating", required = false) Double minRating,
                                 @RequestParam(value = "maxRating", required = false) Double maxRating) {

        ShipOrder order = ShipOrder.ID;
        Integer pageNumber = 0;
        Integer pageSize = Integer.MIN_VALUE;
        return shipService.getAll(name, planet, shipType, after, before, isUsed, minSpeed,
                maxSpeed, minCrewSize, maxCrewSize, minRating, maxRating, order, pageNumber, pageSize).size();
    }
}
