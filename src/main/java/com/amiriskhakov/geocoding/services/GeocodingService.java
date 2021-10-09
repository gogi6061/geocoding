package com.amiriskhakov.geocoding.services;

import com.amiriskhakov.geocoding.entities.GeocodingEntity;
import com.amiriskhakov.geocoding.repositories.GeocodingRepository;

import java.util.Optional;

public interface GeocodingService{

    GeocodingEntity getByAdress(String adress);

    GeocodingEntity getByLatAndLon(String lat, String lon);

}
