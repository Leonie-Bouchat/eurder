package com.switchfully.eurderproject.services.dtos;

import com.switchfully.eurderproject.domain.user.Address;
import com.switchfully.eurderproject.security.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private CreateAddressDto createAddressDto;
    private String phoneNumber;

    private Role role;
    @NotNull
    @Size(min = 2, max = 20)
    private String userName;
    @NotNull
    @Size(min = 2, max = 10)
    private String password;

    public CreateUserDto(String firstName, String lastName, String email, CreateAddressDto address, String phoneNumber, Role role, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createAddressDto = address;
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

    public CreateAddressDto getAddress() {
        return createAddressDto;
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
