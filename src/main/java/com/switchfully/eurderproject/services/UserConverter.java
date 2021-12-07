package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto convertUserInUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstname(user.getFirstname())
                .setLastname(user.getLastname())
                .setRole(user.getRole());
    }

    public User convertCreateUserDtoInUser(CreateUserDto createUserDto) {
        return new User.Builder(createUserDto.getFirstname(), createUserDto.getLastname(), createUserDto.getAddress(), createUserDto.getRole())
                .withEmail(createUserDto.getEmail())
                .withPhoneNumber(createUserDto.getPhoneNumber())
                .withUsername(createUserDto.getUsername())
                .withPassword(createUserDto.getPassword())
                .build();
    }
}
