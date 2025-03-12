package com.example.dad.service;

import com.example.dad.entity.Token;
import com.example.dad.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.List;

@Service
public class TokenService {
    private final TokenRepo repo;

    public TokenService(@Autowired TokenRepo repo) {
        this.repo = repo;
    }

    public List<Token> getAllTokens() {
        return repo.findAll();
    }

    public List<Token> findTokensByUsername(String username) {
        return repo.findByUser_Username(username);

    }

    public Token createToken(Token token) {
        return repo.save(token);
    }

    public void deleteToken(Long id) {
        Token token = repo.findById(id).orElseThrow(() -> new RuntimeException("Token not found"));
        repo.delete(token);
    }

    // handle expired token
    public boolean isTokenExpired(Token token) {
        return token.getValid_date().isBefore(ChronoZonedDateTime.from(LocalDateTime.now()));
    }


}
