package com.jpa.test.services;

import com.jpa.test.entities.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();

    User saveUserInDB(User user);

    User updateUserInDB(User user);

    void deleteUserInDB(Integer userId);

    User findUserById(int uid);
}
