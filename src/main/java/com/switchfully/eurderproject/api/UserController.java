package com.switchfully.eurderproject.api;


import com.switchfully.eurderproject.services.DefaultUserService;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private DefaultUserService userService;

    public UserController(DefaultUserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewUser(@RequestBody CreateUserDto createUserDto){
        UserDto userDto = userService.saveById(createUserDto);
//        LoggerFactory.getLogger(UserController.class).warn(userDto.toString());
        return userDto;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("id") String id,
                               @RequestHeader String authorization){

        return userService.getUserById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }



}
