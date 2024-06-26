package com.edu.api.controller;

import com.edu.api.dto.UserDto;
import com.edu.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("api/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto signIn(@RequestBody UserDto userDto){

        return null;
    }
}
