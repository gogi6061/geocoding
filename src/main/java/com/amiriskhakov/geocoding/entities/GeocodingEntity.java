package com.amiriskhakov.geocoding.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table()
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GeocodingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private String lat;

    @Column
    private String lon;

    @Column
    private String adress;

    public GeocodingEntity(String lat, String lon, String adress) {
        this.lat = lat;
        this.lon = lon;
        this.adress = adress;
    }
}
