package com.example.repository;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByRegionIgnoreCase(String region);

    Optional<Location> findByNameIgnoreCase(String name);

    List<Location> findByFareLessThan(Double maxAmount);
}
