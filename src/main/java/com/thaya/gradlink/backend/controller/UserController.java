package com.thaya.gradlink.backend.controller;

import com.thaya.gradlink.backend.entity.User;
import com.thaya.gradlink.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String result = userService.loginUser(username, password);

        if (result.startsWith("/")) {
            // Redirect to the appropriate dashboard
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", result).build();
        } else {
            // Return error message
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }

}
