package com.edu.api.controller;

import com.edu.api.dto.UserDto;
import com.edu.api.entity.Role;
import com.edu.api.entity.User;
import com.edu.api.security.JwtTokenProvider;
import com.edu.api.service.AuthService;
import com.edu.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto);
        UserDto userDtoResponse = new UserDto();
        userDtoResponse.setEmail(user.getEmail());
        userDtoResponse.setPassword(user.getPassword());
        userDtoResponse.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return userDtoResponse;
    }

    @PostMapping("/login")
    public Map<String, String> signIn(@RequestBody UserDto userDto){

        String token = authService.signInWithJwt(userDto);
        return Map.of("jwt-token", token);
    }
}
