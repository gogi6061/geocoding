package com.amiriskhakov.geocoding.services;

import com.amiriskhakov.geocoding.entities.GeocodingEntity;
import com.amiriskhakov.geocoding.exceptions.GeocodingEntityNotFound;
import com.amiriskhakov.geocoding.repositories.GeocodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeocodingServiceImpl implements GeocodingService {

    private final GeocodingRepository geocodingRepository;

    @Autowired
    public GeocodingServiceImpl(GeocodingRepository geocodingRepository) {
        this.geocodingRepository = geocodingRepository;
    }


    @Override
    public GeocodingEntity getByAdress(String adress) {
        return geocodingRepository.findByAdress(adress)
                .orElse(new GeocodingEntity(null,null,null));
    }


    @Override
    public GeocodingEntity getByLatAndLon(String lat, String lon) {

        return geocodingRepository.findByLatAndLon(lat, lon)
                .orElse(new GeocodingEntity(null,null,null));
    }
}
