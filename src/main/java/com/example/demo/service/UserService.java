package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();

    User getUserById(Long id);

    void saveOrUpdateUser(User user);

    void deleteUserById(Long id);

    Role getRoleByName(String name);

    void saveRole(Role role);

    User getUserByUsername(String username);
}
