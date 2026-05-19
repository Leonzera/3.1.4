package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User getUserById(Long id);

    void saveOrUpdateUser(User user);

    void deleteUserById(Long id);

    User getUserByUsername(String username);

    Role getRoleByName(String name);

    void saveRole(Role role);
}
