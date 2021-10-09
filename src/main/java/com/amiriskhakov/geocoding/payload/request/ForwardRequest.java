package com.amiriskhakov.geocoding.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForwardRequest {

    public String city;

    public String street;

    public String county;


}
