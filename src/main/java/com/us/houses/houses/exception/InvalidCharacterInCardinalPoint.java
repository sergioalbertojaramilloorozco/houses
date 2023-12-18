package com.us.houses.houses.exception;

public class InvalidCharacterInCardinalPoint extends RuntimeException {

    public static final String INVALID_CARDINAL_POINT_ERROR_MESSAGE = "Cardinal point should not have symbols like [, or ;]";
    public InvalidCharacterInCardinalPoint(){
        super(INVALID_CARDINAL_POINT_ERROR_MESSAGE);
    }
}
