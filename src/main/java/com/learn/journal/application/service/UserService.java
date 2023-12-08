package com.learn.journal.application.service;

import com.learn.journal.application.model.User;
import com.learn.journal.application.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
       return userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(ObjectId id, User user) {
        User oldUser = userRepository.findById(id).orElse(null);
        if (oldUser != null) {
            oldUser.setUsername(oldUser.getUsername().equals(user.getUsername()) ? oldUser.getUsername() : user.getUsername());
            oldUser.setPassword(oldUser.getPassword().equals(user.getPassword()) ? oldUser.getPassword() : user.getPassword());
            userRepository.save(oldUser);
        }
    }

    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    public void deleteUserById(ObjectId id) {
        userRepository.deleteById(id);
    }
}
