package com.us.houses.houses.repository;

import com.us.houses.houses.model.House;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseRepository extends MongoRepository<House, String> {
}
