package com.us.houses.houses.model;

import com.us.houses.houses.exception.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class House {

    @Getter
    @Id
    private String id;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    private String zipCode;

    @Setter
    @Getter
    private double latitude;

    @Setter
    @Getter
    private double longitude;

    public House(String address, String zipCode, double latitude, double longitude) {
        this.address = validateAddress(address);
        this.zipCode = validateZipCode(zipCode);
        this.latitude = validateCardinalPoints(latitude);
        this.longitude = validateCardinalPoints(longitude);
    }

    private String validateAddress(String address) {
        if (address.isEmpty()) {
            throw new AddressNotValid();
        } else {
            return address;
        }
    }

    private String validateZipCode(String zipCode) {
        if ((zipCode.length() == 5) || (zipCode.length() == 6)) {
            return zipCode;
        } else {
            throw new ZipCodeIsWrong();
        }
    }

    private double validateCardinalPoints(double point){
        validateIfIsNotNull(point);
        validateIfPointIsInRange(point);
        String numberToString = String.valueOf(point);
        if (numberToString.matches("^[,;]+$")){
            throw new InvalidCharacterInCardinalPoint();
        } else {
            return point;
        }
    }

    private void validateIfIsNotNull(double point) {
        if (String.valueOf(point).length() == 0) {
            throw new CardinalPointShouldNotBeNull();
        }
    }

    private void validateIfPointIsInRange(double point) {
        if (point < -180 || point > 180) throw new InvalidRangeInCardinalPoint();
    }
}
