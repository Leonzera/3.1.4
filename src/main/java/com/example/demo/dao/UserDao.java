package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User findUserById(Long id);

    void saveOrUpdateUser(User user);

    void deleteUserById(Long id);
}
