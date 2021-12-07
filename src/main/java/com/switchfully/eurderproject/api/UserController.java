package com.switchfully.eurderproject.api;


import com.switchfully.eurderproject.services.DefaultUserService;
import com.switchfully.eurderproject.services.dtos.CreateUserDto;
import com.switchfully.eurderproject.services.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private DefaultUserService userService;

    public UserController(DefaultUserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createNewUser(@RequestBody CreateUserDto createUserDto){
        UserDto userDto = userService.saveById(createUserDto);
//        LoggerFactory.getLogger(UserController.class).warn(userDto.toString());
        return userDto;
    }


}
