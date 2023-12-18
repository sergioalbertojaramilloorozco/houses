package com.us.houses.houses.service;

import com.us.houses.houses.model.House;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HouseServiceTest {

    @Autowired
    private HouseInterface houseInterface;

    private List<House> listOfHouses
            = Arrays.asList(
                    new House("91877600", "New york", "10001", 20.001, 10.102),
                    new House("91870011", "Chicago", "60007", 29.001, -11.102));

    private House house;

    private String address = "Street 30 # 20 -25 Marinilla, Colombia";

    private String zipCode = "054020";

    @Test
    public void creatingNewHouseTest() {

        //arrange
        house = new House(address, zipCode, -12.002, -18.0012);

        //act
        House houseCreated = houseInterface.create(house);

        //assert
        assertNotNull(houseCreated.getId());
        assertEquals(houseCreated.getAddress(), address);
        assertEquals(houseCreated.getZipCode(), zipCode);

    }

    @Test
    public void houseByIdWasNotFoundTest() {

        //arrange
        String id = "918776";

        //act
        ResponseEntity houseCreated = houseInterface.retrieveHouseById(id);

        //assert
        assertEquals(HttpStatus.NOT_FOUND, houseCreated.getStatusCode());

    }

    @Test
    public void houseByIdWasFoundTest() {

        //arrange
        String id = "91877600";

        //When it is calling iHouseService.retrieveHouseById(id) and found the record retrieve one and it is showed

        List<House> houseFound = listOfHouses.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
        //act
        new ResponseEntity<>(houseFound, HttpStatus.OK);

        //assert
        assertNotNull(houseFound);
        assertEquals("New york", houseFound.get(0).getAddress());

    }

    @Test
    public void findAllTest() {
        //When it is calling iHouseService.all and it is showing all records the database has
        List<House> houseFound = listOfHouses.stream().collect(Collectors.toList());
        //act
        new ResponseEntity<>(houseFound, HttpStatus.OK);
        //assert
        assertTrue(houseFound.size() > 1);

    }

}
