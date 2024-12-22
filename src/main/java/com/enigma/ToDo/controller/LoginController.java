package com.enigma.ToDo.controller;

import com.enigma.ToDo.constant.UserRole;
import com.enigma.ToDo.dto.request.LoginRequest;
import com.enigma.ToDo.dto.request.RegisterRequest;
import com.enigma.ToDo.entity.User;
import com.enigma.ToDo.utils.ApiResponse;
import com.enigma.ToDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request.getUsername(), request.getPassword());
        if (user == null) {
            return new ResponseEntity<>(new ApiResponse("Invalid credentials", false), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new ApiResponse("Logged in successfully", true), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(UserRole.ROLE_USER)
                .build();
        userService.createUser(user);
        return new ResponseEntity<>(new ApiResponse("User registered successfully", true), HttpStatus.CREATED);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<ApiResponse> registerAdmin(@RequestBody RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(UserRole.ROLE_ADMIN)
                .build();
        userService.createUser(user);
        return new ResponseEntity<>(new ApiResponse("User registered successfully", true), HttpStatus.CREATED);
    }
}