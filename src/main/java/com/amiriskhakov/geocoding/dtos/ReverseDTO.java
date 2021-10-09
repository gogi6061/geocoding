package com.amiriskhakov.geocoding.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReverseDTO {
    @JsonIgnore
    private String country;

    @JsonIgnore
    private String city;

    @JsonIgnore
    private String street;

    @JsonIgnore
    private String county;

    private String fullName;





    public ReverseDTO(String fullName) {
        this.fullName = fullName;
    }


}
