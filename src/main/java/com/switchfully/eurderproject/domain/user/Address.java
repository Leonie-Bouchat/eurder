package com.switchfully.eurderproject.domain.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @NotNull
    @Id
    @Column(name = "ADDRESS_ID")
    private String id;

    @NotNull
    @Column(name = "STREET_NAME")
    private String streetName;

    @NotNull
    @Column(name = "STREET_NUMBER")
    private int streetNumber;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "POSTAL_CODE")
    private City city;


//    public Address(Builder builder) {
//        this.id = UUID.randomUUID().toString();
//        this.streetName = builder.streetName;
//        this.streetNumber = builder.streetNumber;
//        this.city = builder.city;
//    }

    public Address(String streetName, int streetNumber, City city) {
        this.id = UUID.randomUUID().toString();
        this.streetName = Objects.requireNonNull(streetName);
        this.streetNumber = streetNumber;
        this.city = city;
    }

    public Address() {

    }

//    public static class Builder {
//        private String streetName;
//        private int streetNumber;
//        private City city;
//
//        public Builder withStreetName(String streetName) {
//            this.streetName = streetName;
//            return this;
//        }
//
//        public Builder withStreetNumber(int streetNumber) {
//            this.streetNumber = streetNumber;
//            return this;
//        }
//
//        public Builder withCity(City city) {
//            this.city = city;
//            return this;
//        }
//
//        public Address build() {
//            return new Address(this);
//        }
//    }
}
