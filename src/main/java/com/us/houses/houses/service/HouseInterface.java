package com.us.houses.houses.service;

import com.us.houses.houses.model.House;
import com.us.houses.houses.model.ResponseError;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HouseInterface {

    House create(House house);

    ResponseEntity<House> delete(String id);

    ResponseEntity<House> update(House house, String id);

    List<House> retrieveHouses();

    ResponseEntity<House> retrieveHouseById(String id);

}
