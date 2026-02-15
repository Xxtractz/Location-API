package com.example.model;

public record LocationDTO(Long id, String region, String name, Double fare) {

    public static LocationDTO from(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getRegion(),
                location.getName(),
                location.getFare()
        );
    }
}
