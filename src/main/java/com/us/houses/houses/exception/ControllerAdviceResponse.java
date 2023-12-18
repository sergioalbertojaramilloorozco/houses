package com.us.houses.houses.exception;

import com.us.houses.houses.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ZipCodeIsWrong.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForBadZipCode(){
        return new ResponseEntity<ResponseError>(new ResponseError(ZipCodeIsWrong.ZIP_CODE_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(AddressNotValid.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForBadAddress(){
        return new ResponseEntity<ResponseError>(new ResponseError(AddressNotValid.ADDRESS_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidCharacterInCardinalPoint.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForIlegalCharactersCardinalPoint(){
        return new ResponseEntity<ResponseError>(new ResponseError(InvalidCharacterInCardinalPoint.INVALID_CARDINAL_POINT_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CardinalPointShouldNotBeNull.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForNullValueInCardinalPoint(){
        return new ResponseEntity<ResponseError>(new ResponseError(CardinalPointShouldNotBeNull.CARDINAL_POINT_NULL_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidRangeInCardinalPoint.class)
    public ResponseEntity<ResponseError> houseWasNotCreatedForInvalidValueInCardinalPoint(){
        return new ResponseEntity<ResponseError>(new ResponseError(InvalidRangeInCardinalPoint.INVALID_RANGE_IN_CARDINAL_POINT_ERROR_MESSAGE), HttpStatus.NOT_ACCEPTABLE);
    }
}
