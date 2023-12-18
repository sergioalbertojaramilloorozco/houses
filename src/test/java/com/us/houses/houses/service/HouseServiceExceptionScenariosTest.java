package com.us.houses.houses.service;

import com.us.houses.houses.exception.AddressNotValid;
import com.us.houses.houses.exception.InvalidRangeInCardinalPoint;
import com.us.houses.houses.model.House;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HouseServiceExceptionScenariosTest {

    private HouseInterface houseInterface = Mockito.mock(HouseInterface.class);

    private House house;

    private String address = "Street 30 # 20 -25 Marinilla, Colombia";

    private String zipCode = "054020";


    @Test
    public void wasNotCreatedNewHouseTest() {

        Exception exception = assertThrows((InvalidRangeInCardinalPoint.class), () -> {
            house = new House(address, zipCode, -12.002, -181.0012);
        });

        String expectedMessage = InvalidRangeInCardinalPoint.INVALID_RANGE_IN_CARDINAL_POINT_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        Mockito.verify(houseInterface, Mockito.never()).create(house);

    }

    @Test
    public void wasNotCreatedNewHouseForErrorInAddressTest() {

        Exception exception = assertThrows((AddressNotValid.class), () -> {
            house = new House("", zipCode, -12.002, -181.0012);
        });

        String expectedMessage = AddressNotValid.ADDRESS_ERROR_MESSAGE;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        Mockito.verify(houseInterface, Mockito.never()).create(house);

    }
}
