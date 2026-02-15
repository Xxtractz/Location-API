package com.example.controller;

import com.example.model.Location;
import com.example.model.LocationDTO;
import com.example.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public List<LocationDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO saveLocation(@Valid @RequestBody Location location) {
        return service.saveLocation(location);
    }

    @GetMapping("/region")
    public List<LocationDTO> findByRegion(@RequestParam String region) {
        return service.findLocationByRegion(region);
    }

    @GetMapping("/location")
    public LocationDTO findByName(@RequestParam String location) {
        return service.findLocationByName(location);
    }

    @GetMapping("/maxFare")
    public List<LocationDTO> findByFareLessThan(@RequestParam Double maxAmount) {
        return service.filterByFareLessThan(maxAmount);
    }

    @GetMapping("/calculateFare")
    public Map<String, Object> calculateFare(@RequestParam String name,
                                             @RequestParam int numberOfCustomers) {
        double totalFare = service.calculateFare(name, numberOfCustomers);
        return Map.of(
                "location", name,
                "customers", numberOfCustomers,
                "totalFare", totalFare
        );
    }
}
