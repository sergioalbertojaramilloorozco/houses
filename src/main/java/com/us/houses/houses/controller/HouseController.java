package com.us.houses.houses.controller;

import com.us.houses.houses.model.House;
import com.us.houses.houses.model.ResponseError;
import com.us.houses.houses.service.HouseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/houses")
public class HouseController {

    @Autowired
    private HouseInterface houseInterface;

    @GetMapping("/all")
    private List<House> retrieveListOfHouses(){
        return houseInterface.retrieveHouses();
    }

    @GetMapping("/{id}")
    private ResponseEntity retrieveHouseById(@PathVariable String id){
        return houseInterface.retrieveHouseById(id);
    }

    @PostMapping
    private ResponseEntity<House> createHouse(@RequestBody House house) {
        return new ResponseEntity<>(houseInterface.create(house), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity updateHouse(@RequestBody House house,  @PathVariable String id) {
        return houseInterface.update(house, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteHouse(@PathVariable String id){
        return houseInterface.delete(id);
    }
}
