package com.switchfully.eurderproject.services.dtos;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.security.Role;

import java.util.Objects;

//record UserDto(String UserId, String firstName) {}

public class UserDto {
    private String UserId;
    private String firstname;
    private String lastname;
    private Role role;

    public UserDto setId(String UserId) {
        this.UserId = UserId;
        return this;
    }

    public UserDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserDto setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getUserId() {
        return UserId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "UserId='" + UserId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                '}';
    }
}
