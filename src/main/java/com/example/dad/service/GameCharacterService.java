package com.example.dad.service;

import com.example.dad.entity.GameCharacter;
import com.example.dad.repository.GameCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameCharacterService {
    private final GameCharacterRepo repo;

    public GameCharacterService(@Autowired GameCharacterRepo repo) {
        this.repo = repo;
    }

    public List<GameCharacter> getAllCharacters() {
        return repo.findAll();
    }

    public List<GameCharacter> getCharactersByUsername(String username) {
        return repo.findByUser_Username(username);
    }

    public List<GameCharacter> getCharacterByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    public Optional<GameCharacter> getCharacterByName(String name) {
        return repo.findByName(name);
    }

    public List<GameCharacter> getCharacterByStrength(Integer strength) {
        return repo.findByStrength(strength);
    }

    public void addCharacter(GameCharacter character) {
        repo.save(character);
    }

    public void updateCharacter(Long id, GameCharacter updatedCharacter) {
        if (repo.existsById(id)) {
            repo.save(updatedCharacter);
        } else {
            throw new RuntimeException("Character not found");
        }
    }

    public void deleteCharacter(Long id) {
        repo.deleteById(id);
    }


}
