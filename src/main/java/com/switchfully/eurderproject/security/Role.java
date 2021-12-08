package com.switchfully.eurderproject.security;

import java.util.List;

import static com.switchfully.eurderproject.security.Features.GET_ALL_USERS;
import static com.switchfully.eurderproject.security.Features.GET_USER_BY_ID;

public enum Role {
    ADMIN(List.of(GET_ALL_USERS, GET_USER_BY_ID)),
    CUSTOMER(List.of());

    private final List<Features> listOfFeatures;

    Role(List<Features> listOfFeatures) {
        this.listOfFeatures = listOfFeatures;
    }
}
