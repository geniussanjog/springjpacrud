package com.jpa.test.controller;

import com.jpa.test.entities.User;
import com.jpa.test.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HomeController {
    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/display")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userServiceInterface.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userServiceInterface.saveUserInDB(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User jiskoUpdateKarnaHaiVoUser = userServiceInterface.findUserById(user.getUid());
        jiskoUpdateKarnaHaiVoUser.setCity(user.getCity());
        jiskoUpdateKarnaHaiVoUser.setName(user.getName());
        jiskoUpdateKarnaHaiVoUser.setStatus(user.getStatus());
        User updatedUser = userServiceInterface.updateUserInDB(jiskoUpdateKarnaHaiVoUser);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId){
        userServiceInterface.deleteUserInDB(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
