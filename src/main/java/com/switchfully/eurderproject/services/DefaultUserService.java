package com.switchfully.eurderproject.services;

import com.switchfully.eurderproject.domain.user.City;
import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.repositories.DefaultCityRepository;
import com.switchfully.eurderproject.repositories.DefaultUserRepository;
import com.switchfully.eurderproject.services.converter.UserConverter;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class DefaultUserService {
    private DefaultUserRepository userRepository;
    private UserConverter userConverter;
    private DefaultCityRepository defaultCityRepository;


    public DefaultUserService(DefaultUserRepository userRepository, UserConverter userConverter, DefaultCityRepository defaultCityRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.defaultCityRepository = defaultCityRepository;
    }

    public UserDto saveById(CreateUserDto createUserDto) {
        City city = defaultCityRepository.findById(createUserDto.getAddress().createCityDto().postalCode())
                .orElseGet(() -> defaultCityRepository.save(new City(createUserDto.getAddress().createCityDto().postalCode(), createUserDto.getAddress().createCityDto().city())));
        User user = userConverter.convertCreateUserDtoInUser(createUserDto, city);
        User newUser = userRepository.saveById(user);
        return userConverter.convertUserInUserDto(newUser);
    }

    public UserDto getUserById(String id) {
        User user = userRepository.getUserById(id);
        return userConverter.convertUserInUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return userConverter.convertListOfUserInListOfUserDto(users);
    }
}
