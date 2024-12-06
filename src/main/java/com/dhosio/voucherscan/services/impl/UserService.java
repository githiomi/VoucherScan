package com.dhosio.voucherscan.services.impl;

import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void init(User user) {
        this.userRepository.save(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User findUserById(String id) {
        return this.userRepository.findUserByEmpId(id);
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

}
