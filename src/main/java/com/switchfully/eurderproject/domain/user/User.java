package com.switchfully.eurderproject.domain.user;

import com.switchfully.eurderproject.security.Role;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private Address address;
    private String phoneNumber;

    private final Role role;
    private String userName;
    private String password;

    public User(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public String getId() {
        return id;
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

    public static class Builder {
        private final String firstName;  // obligated
        private final String lastName;
        private final Address address;
        private final Role role;

        private String email; // optional
        private String phoneNumber;
        private String userName;
        private String password;

        public Builder(String firstname, String lastname, Address address, Role role) {
            this.firstName = firstname;
            this.lastName = lastname;
            this.address = address;
            this.role = role;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withUsername(String username) {
            this.userName = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
