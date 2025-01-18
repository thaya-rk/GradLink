package com.thaya.gradlink.backend.service.impl;

import com.thaya.gradlink.backend.config.CustomUserDetails;
import com.thaya.gradlink.backend.entity.User;
import com.thaya.gradlink.backend.repository.UserRepository;
import com.thaya.gradlink.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Implement loadUserByUsername to look up by email
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to load user with username/email: " + username); // Log the username
        Optional<User> userOptional = userRepository.findByEmail(username);  // Use email for lookup
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println("User found: " + user); // Log the user
        System.out.println("Stored password hash: " + user.getPassword());  // Log stored password hash

        return new CustomUserDetails(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
