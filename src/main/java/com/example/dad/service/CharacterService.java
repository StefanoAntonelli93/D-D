package com.example.dad.service;

import com.example.dad.repository.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepo repo;

    public CharacterService(@Autowired CharacterRepo repo) {
        this.repo = repo;
    }

    public List<Character> getAllCharacters() {
        return repo.findAll();
    }

    public List<Character> getCharacterByUsername(String username) {
        return repo.findByUsername(username);
    }

    public List<Character> getCharacterByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    public Optional<Character> getCharacterByName(String name) {
        return repo.findByName(name);
    }

    public List<Character> getCharacterByStrength(Integer strength) {
        return repo.findByStrength(strength);
    }

    public void addCharacter(Character character) {
        repo.save(character);
    }

    public void updateCharacter(Long id, Character updatedCharacter) {
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
