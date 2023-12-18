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
    public ResponseEntity<House> delete(String id) {
        if (houseRepository.findById(id).isPresent()) {
            houseRepository.deleteById(id);
            return new ResponseEntity("House : " + id + " delete successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity((new ResponseError("Not found")), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<House> update(House house, String id) {
        ResponseEntity<House> validateIfExistHouse = retrieveHouseById(id);
        if (validateIfExistHouse.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return new ResponseEntity("House : " + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(houseRepository.save(house), HttpStatus.OK);
        }
    }

    @Override
    public List<House> retrieveHouses() {
        return houseRepository.findAll();
    }

    @Override
    public ResponseEntity<House> retrieveHouseById(String id) {
        Optional<House> houseFounded = houseRepository.findById(id);
        if (houseFounded.isPresent()) {
            return new ResponseEntity<>(houseFounded.get(), HttpStatus.OK);
        } else {
           return new ResponseEntity("House : " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    private House validateIfSomethingIsWrong(House house) {
        return new House(house.getAddress(), house.getZipCode(), house.getLatitude(), house.getLongitude());
    }
}
