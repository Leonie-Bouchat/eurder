package com.switchfully.eurderproject.services.dtos;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.security.Role;
import lombok.Getter;

@Getter
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

    private Role role;
    private String userName;
    private String password;

    public CreateUserDto(String firstName, String lastName, String email, Address address, String phoneNumber, Role role, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
