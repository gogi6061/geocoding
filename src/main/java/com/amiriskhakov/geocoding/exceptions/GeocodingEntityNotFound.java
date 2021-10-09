package com.amiriskhakov.geocoding.exceptions;

public class GeocodingEntityNotFound extends RuntimeException {
    String message;
    public GeocodingEntityNotFound(String message) {
        super(message);


    }
}
