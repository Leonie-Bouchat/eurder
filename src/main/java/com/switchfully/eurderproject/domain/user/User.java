package com.switchfully.eurderproject.domain.user;

import com.switchfully.eurderproject.security.Role;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private Address address;
    private String phoneNumber;

    private final Role role;
    private String username;
    private String password;

    public User(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getId() {
        return id;
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

    public static class Builder {
        private final String firstname;  // obligated
        private final String lastname;
        private final Address address;
        private final Role role;

        private String email; // optional
        private String phoneNumber;
        private String username;
        private String password;

        public Builder(String firstname, String lastname, Address address, Role role) {
            this.firstname = firstname;
            this.lastname = lastname;
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
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
