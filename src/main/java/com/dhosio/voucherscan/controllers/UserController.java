package com.dhosio.voucherscan.controllers;

import com.dhosio.voucherscan.models.ApiResponse;
import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        return new ResponseEntity<>(new ApiResponse<List<User>>(userServiceImpl.getAll(), LocalDateTime.now(), true), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<User>> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(new ApiResponse<User>(userServiceImpl.findUserByUsername(username.toUpperCase()), LocalDateTime.now(), true), HttpStatus.OK);
    }

}
