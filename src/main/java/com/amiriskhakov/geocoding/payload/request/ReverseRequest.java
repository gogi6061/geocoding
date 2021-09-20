package com.amiriskhakov.geocoding.payload.request;

public class ReverseRequest {
    private String lat;

    private String lon;

    public ReverseRequest() {
    }

    public ReverseRequest(String lat, String lon) {
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
