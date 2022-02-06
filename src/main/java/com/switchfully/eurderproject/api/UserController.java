package com.switchfully.eurderproject.api;


import com.switchfully.eurderproject.domain.user.User;
import com.switchfully.eurderproject.services.DefaultUserService;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private DefaultUserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(DefaultUserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewUser(@Valid @RequestBody CreateUserDto createUserDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.toString());
        }
        UserDto userDto = userService.saveById(createUserDto);
        logger.warn(userDto.toString());
        logger.info("New user created");
        return userDto;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("id") String id){
        logger.info("found user by ID");
        return userService.getUserById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        logger.info("found all users");
        return userService.getAllUsers();
    }



}
