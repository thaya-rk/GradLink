package com.thaya.gradlink.backend.config;

import com.thaya.gradlink.backend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final UserService userService;

    public SecurityConfig(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService) // This ensures `UserService` is used
                .passwordEncoder(passwordEncoder());
        System.out.println("Authentication Manager configured"); // Log when it's configured
        return authenticationManagerBuilder.build();
    }


    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/login", "/api/auth/register", "/public/**").permitAll() // Public endpoints
                    .requestMatchers("/students/**").hasRole("STUDENT") // Only users with "STUDENT" role
                    .requestMatchers("/tpo/**").hasRole("TPO")         // Only users with "TPO" role
                    .requestMatchers("/companies/**").hasRole("COMPANY") // Only users with "COMPANY" role
                    .anyRequest().authenticated()
            )
            .logout(logout -> logout
                    .logoutUrl("/api/auth/logout")
                    .logoutSuccessUrl("/api/auth/login?logout")
                    .permitAll()
            );

    return http.build();
}

}
