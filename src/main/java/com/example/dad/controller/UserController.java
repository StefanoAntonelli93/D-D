package com.example.dad.controller;

import com.example.dad.entity.User;
import com.example.dad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(@Autowired UserService service) {
        this.service = service;
    }

    @RequestMapping("/dad")
    public String greet() {
        return "Welcome to Dungeon&Dragons App!";
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = service.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)) // use map for Optional
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user/register")
    public String registerUser(@RequestBody User user) {
        boolean isRegistered = service.registerUser(user.getUsername(), user.getEmail());
        if (isRegistered) {
            return "User registered successfully!";
        } else {
            return "User already exists!";
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

}
