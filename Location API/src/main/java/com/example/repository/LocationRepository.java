package com.example.repository;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//THE 'Location' REPOSITORY:
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    //QUERY METHOD 1: FIND LOCATION BY REGION
    List<Location> findByRegionIgnoreCase(String region);

    //QUERY METHOD 2: FIND LOCATION BY NAME
    Location findByNameIgnoreCase(String name);

    //QUERY METHOD 3: FILTER BY FARE AMOUNT LESS THAN
    @Query("SELECT l FROM Location l WHERE l.fare < :maxAmount")
    List<Location> findByFareLessThan(@Param("maxAmount") Double maxAmount);

    //QUERY METHOD 4: CALCULATE FARE BASED ON NUMBER OF CUSTOMERS/PASSENGERS
    @Query("SELECT l.fare FROM Location l WHERE l.name = :location")
    Double calculateFareBasedOnLocation(@Param("location") String name);
}
