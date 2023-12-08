package com.learn.journal.application.controller;

import com.learn.journal.application.model.User;
import com.learn.journal.application.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable ObjectId id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping
    public boolean createUser(@RequestBody User user) {
        userService.createUser(user);
        return true;
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable ObjectId id, @RequestBody User user) {
        userService.updateUser(id, user);
        return true;
    }

    @DeleteMapping
    public boolean deleteAllUser() {
        userService.deleteAllUser();
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deleteUserById(@PathVariable ObjectId id) {
        userService.deleteUserById(id);
        return true;
    }
}
