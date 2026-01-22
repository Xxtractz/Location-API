package com.example.service;

import com.example.model.Location;
import com.example.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//THE 'Location' SERVICE CLASS:
@Service
public class LocationService {
    private LocationRepository repository;

    //CONSTRUCTOR INJECTION:
    public LocationService(LocationRepository repository){
        this.repository = repository;
    }

    //THE 'saveLocation()' SERVICE METHOD:
    public Location saveLocation(Location location){
        return repository.save(location);
    }

    //THE 'findLocationByRegion()' SERVICE METHOD:
    public List<Location> findLocationByRegion(String region){
        return repository.findByRegionIgnoreCase(region);
    }

    //THE 'findByLocationByName()' SERVICE METHOD:
    public Location findLocationByName(String name){
        return repository.findByNameIgnoreCase(name);
    }

    //THE 'filterByFareLessThan()' SERVICE METHOD:
    public List<Location> filterByFareLessThan(Double maxAmount){
        return repository.findByFareLessThan(maxAmount);
    }

    //THE 'calculateFareBasedOnCustomers()' SERVICE METHOD:
    public Double calculateFareBasedOnCustomers(String name){
        return repository.calculateFareBasedOnLocation(name);
    }


}
