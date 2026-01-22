package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//THE 'Location' ENTITY CLASS:
@Entity
public class Location {
    //THE CLASS PROPERTIES:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String name;
    private Double fare;

    //THE DECORATED CONSTRUCTORS:
    public Location(String region, String name, Double fare){
        this.region = region;
        this.name = name;
        this.fare = fare;
    }
    //THE DEFAULT CONSTRUCTOR:
    public Location(){}

    //GETTERS & SETTERS:
    public String getRegion(){
        return region;
    }
    public void setLocation(String location){
        this.region = location;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Double getFare(){
        return fare;
    }
    public void setFare(Double fare){
        this.fare = fare;
    }
}
