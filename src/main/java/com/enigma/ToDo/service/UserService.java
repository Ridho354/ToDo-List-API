package com.enigma.ToDo.service;

import com.enigma.ToDo.entity.User;

public interface UserService {
    User loginUser(String username, String password);
    User createUser(User user);
}
