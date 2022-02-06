package com.switchfully.eurderproject.services.converter;

import com.switchfully.eurderproject.domain.user.City;
import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    private AddressConverter addressConverter;

    @Autowired
    public UserConverter(AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    public UserDto convertUserInUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRole(user.getRole());
    }

    public User convertCreateUserDtoInUser(CreateUserDto createUserDto, City city) {
        return new User(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getEmail(), addressConverter.convertCreateAddressDtoInAddress(createUserDto.getAddress(), city), createUserDto.getPhoneNumber(), createUserDto.getRole(), createUserDto.getUserName(), createUserDto.getPassword());
    }

    public List<UserDto> convertListOfUserInListOfUserDto(List<User> users) {
        List<UserDto> usersDto = users.stream().map(user -> convertUserInUserDto(user)).toList();
        return usersDto;
    }
}
