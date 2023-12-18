package com.us.houses.houses.model.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "house")
public class HouseDAO {

    @Id
    private String id;

    private String address;

    private String zipCode;

    private Long latitude;

    private Long longitude;

    public HouseDAO(String address, String zipCode, Long latitude, Long longitude) {
        this.address = address;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Long getLongitude() {
        return longitude;
    }
}
