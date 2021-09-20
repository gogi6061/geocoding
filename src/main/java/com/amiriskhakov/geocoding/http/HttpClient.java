package com.amiriskhakov.geocoding.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class HttpClient {
    OkHttpClient client = new OkHttpClient();



    public HttpClient() throws IOException {
    }

    public Response requestForReverse(String lat, String lon) throws IOException {
        String stringForReverse = String.format("https://forward-reverse-geocoding.p.rapidapi.com/v1/reverse?lat=%s&lon=%s", lat, lon);

        Request requestForForward = new Request.Builder()
                .url(stringForReverse)
                .get()
                .addHeader("x-rapidapi-host", "forward-reverse-geocoding.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "")
                .build();

        return client.newCall(requestForForward).execute();
    }

    public Response requestForForward(String city) throws IOException {
        String stringForReverse = String.format("https://forward-reverse-geocoding.p.rapidapi.com/v1/forward?city=%s", city);

        Request requestForForward = new Request.Builder()
                .url(stringForReverse)
                .get()
                .addHeader("x-rapidapi-host", "forward-reverse-geocoding.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "")
                .build();

        return client.newCall(requestForForward).execute();
    }

    public Response requestForForward(String city, String street) throws IOException {
        String stringForReverse = String.format("https://forward-reverse-geocoding.p.rapidapi.com/v1/forward?city=%s&street=%s", city, street);

        Request requestForForward = new Request.Builder()
                .url(stringForReverse)
                .get()
                .addHeader("x-rapidapi-host", "forward-reverse-geocoding.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "63dde7146fmshe14b70d412fd5fap178362jsnc4cf6c655494")
                .build();

        return client.newCall(requestForForward).execute();
    }
}
