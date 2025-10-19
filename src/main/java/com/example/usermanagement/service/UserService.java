package com.example.usermanagement.service;

import com.example.usermanagement.exception.ResourceNotFoundException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this as a service class for business logic
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE a new user
    public User createUser(User user) {
        // Optional: check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }
        return userRepository.save(user);
    }

    // READ all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    // UPDATE user
    public User updateUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPassword(userDetails.getPassword());
        return userRepository.save(existingUser);
    }

    // DELETE user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
