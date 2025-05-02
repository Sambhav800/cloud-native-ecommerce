package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public Optional<User> updateUser(String id, User userDetails) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    if (userDetails.getFirstName() != null) {
                        existingUser.setFirstName(userDetails.getFirstName());
                    }
                    if (userDetails.getLastName() != null) {
                        existingUser.setLastName(userDetails.getLastName());
                    }
                    if (userDetails.getEmail() != null) {
                        existingUser.setEmail(userDetails.getEmail());
                    }
                    if (userDetails.getAddress() != null) {
                        existingUser.setAddress(userDetails.getAddress());
                    }
                    if (userDetails.getPhone() != null) {
                        existingUser.setPhone(userDetails.getPhone());
                    }
                    return userRepository.save(existingUser);
                });
    }
    
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
    
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
