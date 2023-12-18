package com.us.houses.houses.exception;

public class AddressNotValid extends RuntimeException {

    public static final String ADDRESS_ERROR_MESSAGE = "Address can not be empty";

    public AddressNotValid() {
        super(ADDRESS_ERROR_MESSAGE);
    }
}
