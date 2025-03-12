package com.example.dad.service;

import com.example.dad.entity.User;
import com.example.dad.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(@Autowired UserRepo repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUsername(String username) {
        return repo.findByUsername(username);
    }

    public void addUser(User user) {
        repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

}
