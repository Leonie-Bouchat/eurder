package com.switchfully.eurderproject.services.dtos;

import com.switchfully.eurderproject.security.Role;

//record UserDto(String UserId, String firstName) {}

public class UserDto {
    private String UserId;
    private String firstName;
    private String lastName;
    private Role role;

    public UserDto setId(String UserId) {
        this.UserId = UserId;
        return this;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDto setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getUserId() {
        return UserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "UserId='" + UserId + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }
}
