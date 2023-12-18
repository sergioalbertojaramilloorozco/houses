package com.us.houses.houses.exception;

public class InvalidRangeInCardinalPoint extends RuntimeException {

    public static final String INVALID_RANGE_IN_CARDINAL_POINT_ERROR_MESSAGE = "Cardinal point should be between -180 and 180 grades";

    public InvalidRangeInCardinalPoint() {
        super(INVALID_RANGE_IN_CARDINAL_POINT_ERROR_MESSAGE);
    }
}
