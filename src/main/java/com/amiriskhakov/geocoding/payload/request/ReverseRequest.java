package com.amiriskhakov.geocoding.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReverseRequest {
    private String lat;

    private String lon;


}
