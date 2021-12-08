package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    public UserDto convertUserInUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRole(user.getRole());
    }

    public User convertCreateUserDtoInUser(CreateUserDto createUserDto) {
        return new User.Builder(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getAddress(), createUserDto.getRole())
                .withEmail(createUserDto.getEmail())
                .withPhoneNumber(createUserDto.getPhoneNumber())
                .withUsername(createUserDto.getUserName())
                .withPassword(createUserDto.getPassword())
                .build();
    }

    public List<UserDto> convertListOfUserInListOfUserDto(List<User> users) {
        List<UserDto> usersDto = users.stream().map(user -> convertUserInUserDto(user)).toList();
        return usersDto;
    }
}
