package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.repositories.DefaultUserRepository;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService {
    private DefaultUserRepository userRepository;
    private UserConverter userConverter;

    public DefaultUserService(DefaultUserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserDto saveById(CreateUserDto createUserDto) {
        User user = userConverter.convertCreateUserDtoInUser(createUserDto);
        User newUser = userRepository.saveById(user);
        return userConverter.convertUserInUserDto(newUser);
    }
}
