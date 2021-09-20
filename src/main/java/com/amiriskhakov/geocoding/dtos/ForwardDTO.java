package com.amiriskhakov.geocoding.dtos;

public class ForwardDTO {
    private String lat;

    private String lon;

    public ForwardDTO() {
    }

    public ForwardDTO(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
