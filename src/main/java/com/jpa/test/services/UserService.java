package com.jpa.test.services;

import com.jpa.test.entities.User;
import com.jpa.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUserInDB(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserInDB(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserInDB(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findUserById(int uid) {
        return userRepository.findById(uid).get();
    }

}
