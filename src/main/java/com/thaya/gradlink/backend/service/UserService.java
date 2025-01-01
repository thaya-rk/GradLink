package com.thaya.gradlink.backend.service;

import com.thaya.gradlink.backend.entity.User;
import com.thaya.gradlink.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // For encrypting passwords

    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return "Username already exists!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return "Invalid username or password!";
        }

        // Check if the password matches
        if (passwordEncoder.matches(password, user.get().getPassword())) {
            String role = user.get().getRole().name();
            switch (role.toUpperCase()) {
                case "STUDENT":
                    return "/students/dashboard";
                case "TPO":
                    return "/tpos/dashboard";
                case "ADMIN":
                    return "/admin/dashboard";
                default:
                    return "Role not recognized!";
            }
        } else {
            return "Invalid username or password!";
        }
    }

}
