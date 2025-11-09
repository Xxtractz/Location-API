package com.example.controller;

import com.example.model.Location;
import com.example.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//THE 'Location' CONTROLLER CLASS:
@RestController
@RequestMapping("api/locations")
public class LocationController {
    private LocationService service;

    public LocationController(LocationService service){
        this.service = service;
    }

    //ENDPOINT A:
    @PostMapping()
    public Location saveLocationEndpoint(@RequestBody Location location){
        return service.saveLocation(location);
    }

    //ENDPOINT B:
    @GetMapping("/region")
    public List<Location> findLocationByRegionEndpoint(@RequestParam String region){
        return service.findLocationByRegion(region);
    }

    //ENDPOINT C:
    @GetMapping("/location")
    public Location findLocationByNameEndpoint(@RequestParam String location){
        return service.findLocationByName(location);
    }

    //ENDPOINT D:
    @GetMapping("/maxFare")
    public List<Location> findFareLessThanEndpoint(@RequestParam Double maxAmount){
        return service.filterByFareLessThan(maxAmount);
    }

    //ENDPOINT E:
    @GetMapping("calculateFare")
    public String calculateFareBasedOnCustomersEndpoint(@RequestParam String name, @RequestParam Integer numberOfCustomers){
        Double fareAmount = service.calculateFareBasedOnCustomers(name) * numberOfCustomers;

        return "The fare to " + name + " for " + numberOfCustomers + " people is " + fareAmount;
    }

}
