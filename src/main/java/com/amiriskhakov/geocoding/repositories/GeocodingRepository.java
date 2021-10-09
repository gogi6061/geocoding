package com.amiriskhakov.geocoding.repositories;

import com.amiriskhakov.geocoding.dtos.ForwardDTO;
import com.amiriskhakov.geocoding.entities.GeocodingEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeocodingRepository extends JpaRepository<GeocodingEntity, Long> {

    Optional<GeocodingEntity> findByAdress(String adress);

    Optional<GeocodingEntity> findByLatAndLon(String lat, String lon);




}
