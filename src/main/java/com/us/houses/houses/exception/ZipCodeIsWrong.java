package com.us.houses.houses.exception;

public class ZipCodeIsWrong extends RuntimeException{

    public static final String ZIP_CODE_ERROR_MESSAGE = "The Zip Code does not have the right format";

    public ZipCodeIsWrong(){
        super(ZIP_CODE_ERROR_MESSAGE);
    }
}
