package com.switchfully.eurderproject.domain.user;

import com.switchfully.eurderproject.security.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "MEMBER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")

    private Address address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Enumerated (EnumType.STRING)
    @Column (name = "ROLE")
    private Role role;

    @Transient
    private String userName;

    @Transient
    private String password;

    public User(String firstName, String lastName, String email, Address address, String phoneNumber, Role role, String userName, String password) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public String getId() {
        return userId;
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

    public String getUserName() {
        return userName;
    }

}
