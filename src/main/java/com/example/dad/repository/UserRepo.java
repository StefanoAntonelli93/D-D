package com.example.dad.repository;


import com.example.dad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);

    User findByUsernameAndEmail(String username, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
