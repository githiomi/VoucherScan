package com.dhosio.voucherscan.controllers;

import com.dhosio.voucherscan.models.ApiResponse;
import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        return new ResponseEntity<>(new ApiResponse<List<User>>(userService.getAll(), LocalDateTime.now(), true), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<User>> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(new ApiResponse<User>(userService.findUserByUsername(username.toUpperCase()), LocalDateTime.now(), true), HttpStatus.OK);
    }

}
