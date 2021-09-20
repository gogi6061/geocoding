package com.amiriskhakov.geocoding.payload.request;

public class ForwardRequest {

    public String city;

    public String street;

    public String county;

    public ForwardRequest(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.county = building;
    }

    public ForwardRequest() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
