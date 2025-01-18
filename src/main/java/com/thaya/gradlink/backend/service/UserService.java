package com.thaya.gradlink.backend.service;

import com.thaya.gradlink.backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {
    User registerUser(User user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Optional<User> getUserByUsername(String username);
}
