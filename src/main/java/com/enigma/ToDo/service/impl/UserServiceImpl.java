package com.enigma.ToDo.service.impl;

import com.enigma.ToDo.entity.User;
import com.enigma.ToDo.repository.UserRepository;
import com.enigma.ToDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}