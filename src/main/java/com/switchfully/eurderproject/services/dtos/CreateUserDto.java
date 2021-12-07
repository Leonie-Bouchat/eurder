package com.switchfully.eurderproject.services.dtos;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.security.Role;
import lombok.Builder;
import lombok.Getter;


public class CreateUserDto {
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phoneNumber;

    private Role role;
    private String username;
    private String password;

    public CreateUserDto(String firstname, String lastname, String email, Address address, String phoneNumber, Role role, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
