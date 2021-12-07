package com.switchfully.eurderproject.api;


import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.UserService;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewUser(@RequestBody CreateUserDto createUserDto){
        UserDto userDto = userService.saveById(createUserDto);
        LoggerFactory.getLogger(UserController.class).warn(userDto.toString());
        return userDto;
    }


}
