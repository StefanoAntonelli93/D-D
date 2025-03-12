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

    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    public User getUsernameAndEmail(String username, String email) {
        return repo.findByUsernameAndEmail(username, email);
    }

    public boolean registerUser(String username, String email) {
        if (repo.existsByUsername(username) || repo.existsByEmail(email)) {
            return false;
        }

        User user = new User(username, email);
        repo.save(user);
        return true;
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

}
