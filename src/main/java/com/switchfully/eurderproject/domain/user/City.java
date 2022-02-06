package com.switchfully.eurderproject.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {
    @Id
    @Column(name="POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String City;

    public City(String postalCode, String city) {
        this.postalCode = postalCode;
        City = city;
    }

    public City() {

    }
}
