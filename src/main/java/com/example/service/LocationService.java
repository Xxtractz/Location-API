package com.example.service;

import com.example.exception.LocationNotFoundException;
import com.example.model.Location;
import com.example.model.LocationDTO;
import com.example.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public LocationDTO saveLocation(Location location) {
        return LocationDTO.from(repository.save(location));
    }

    public List<LocationDTO> findAll() {
        return repository.findAll().stream()
                .map(LocationDTO::from)
                .toList();
    }

    public List<LocationDTO> findLocationByRegion(String region) {
        return repository.findByRegionIgnoreCase(region).stream()
                .map(LocationDTO::from)
                .toList();
    }

    public LocationDTO findLocationByName(String name) {
        return repository.findByNameIgnoreCase(name)
                .map(LocationDTO::from)
                .orElseThrow(() -> new LocationNotFoundException(name));
    }

    public List<LocationDTO> filterByFareLessThan(Double maxAmount) {
        return repository.findByFareLessThan(maxAmount).stream()
                .map(LocationDTO::from)
                .toList();
    }

    public double calculateFare(String name, int numberOfCustomers) {
        Location location = repository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new LocationNotFoundException(name));
        return location.getFare() * numberOfCustomers;
    }
}
