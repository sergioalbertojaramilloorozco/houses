package com.us.houses.houses.service.implentation;

import com.us.houses.houses.model.House;
import com.us.houses.houses.model.ResponseError;
import com.us.houses.houses.repository.HouseRepository;
import com.us.houses.houses.service.HouseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService implements HouseInterface {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public House create(House house) {
        return houseRepository.save(validateIfSomethingIsWrong(house));
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        if (houseRepository.findById(id).isPresent()) {
            houseRepository.deleteById(id);
            return ResponseEntity.ok("House was deleted for id " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<House> update(House house, String id) {
        ResponseEntity<House> validateIfExistHouse = retrieveHouseById(id);
        if (validateIfExistHouse.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(houseRepository.save(house));
        }
    }

    @Override
    public ResponseEntity<List<House>> retrieveHouses() {
        return ResponseEntity.ok(houseRepository.findAll());
    }

    @Override
    public ResponseEntity<House> retrieveHouseById(String id) {
        Optional<House> houseFound = houseRepository.findById(id);
        return houseFound.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private House validateIfSomethingIsWrong(House house) {
        return new House(house.getAddress(), house.getZipCode(), house.getLatitude(), house.getLongitude());
    }
}
