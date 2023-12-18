package com.us.houses.houses.domain;

import com.us.houses.houses.exception.*;
import com.us.houses.houses.model.House;
import com.us.houses.houses.service.HouseInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HouseTest {

    private HouseInterface houseInterface = Mockito.mock(HouseInterface.class);

    private House house;
    private String address = "Street 30 # 20 -25 Marinilla, Colombia";

    private String zipCode = "054020";

    @Test
    public void exceptionWhenGradesAreOutOfAcceptableValuesTest(){ //a act assert

        Exception exception = assertThrows(InvalidRangeInCardinalPoint.class, () -> {
            house = new House(address, zipCode, -12.002, -181.0012);
        });

        String expectedMessageException = InvalidRangeInCardinalPoint.INVALID_RANGE_IN_CARDINAL_POINT_ERROR_MESSAGE;
        String messageFound = exception.getMessage();

        assertTrue(messageFound.contains(expectedMessageException));

    }

    @Test
    public void exceptionWhenAddressIsNotValidTest() {
        Exception exception = assertThrows(AddressNotValid.class, () -> {
            house = new House("", zipCode, -12.002, 18.1229);
        });

        String expectedMessageException = AddressNotValid.ADDRESS_ERROR_MESSAGE;
        String messageFound = exception.getMessage();

        assertTrue(messageFound.contains(expectedMessageException));
        Mockito.verify(houseInterface, Mockito.never());
    }

    @Test
    public void exceptionWhenZipCodeIsNotValidForLengthLessThanExpectedTest() {
        Exception exception = assertThrows(ZipCodeIsWrong.class, () -> {
            house = new House(address, "0520", -12.002, 18.1229);
        });

        String expectedMessageException = ZipCodeIsWrong.ZIP_CODE_ERROR_MESSAGE;
        String messageFound = exception.getMessage();

        assertTrue(messageFound.contains(expectedMessageException));
    }

    @Test
    public void exceptionWhenZipCodeIsNotValidForLengthMoreThanExpectedTest() {
        Exception exception = assertThrows(ZipCodeIsWrong.class, () -> {
            house = new House(address, "0520012", -12.002, 18.1229);
        });

        String expectedMessageException = ZipCodeIsWrong.ZIP_CODE_ERROR_MESSAGE;
        String messageFound = exception.getMessage();

        assertTrue(messageFound.contains(expectedMessageException));
    }

    @Test
    public void houseObjectCreatedTest() {
        house = new House(address, zipCode, -12.002, 18.1229);

        assertNotNull(house);
        assertEquals(house.getAddress(), address);
        assertEquals(house.getZipCode(), zipCode);
    }

}
