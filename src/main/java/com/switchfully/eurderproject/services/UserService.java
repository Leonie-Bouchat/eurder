package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;

public interface UserService {
    UserDto saveById(CreateUserDto createUserDto);
}
