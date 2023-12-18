package com.us.houses.houses.exception;

public class CardinalPointShouldNotBeNull extends RuntimeException {

    public static final String CARDINAL_POINT_NULL_ERROR_MESSAGE = "Cardinal point should not be null";

    public CardinalPointShouldNotBeNull(){
        super(CARDINAL_POINT_NULL_ERROR_MESSAGE);
    }
}
