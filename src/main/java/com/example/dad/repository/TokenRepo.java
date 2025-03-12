package com.example.dad.repository;


import com.example.dad.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {
    List<Token> findByUser_Username(String username);
}
