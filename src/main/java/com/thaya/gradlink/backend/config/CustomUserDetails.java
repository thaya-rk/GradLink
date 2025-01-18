package com.thaya.gradlink.backend.config;


import com.thaya.gradlink.backend.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assign role-based authorities based on the role of the user
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();  // or username depending on how you're identifying users
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can change this logic as per your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can add actual logic here
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can add actual logic here
    }

    @Override
    public boolean isEnabled() {
        return true; // You can add logic for account activation here
    }

    public User getUser() {
        return user;
    }
}