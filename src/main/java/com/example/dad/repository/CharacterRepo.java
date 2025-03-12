package com.example.dad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends JpaRepository<Character, Long> {
    Optional<Character> findByName(String name);

    List<Character> findByStrength(Integer strength);
}
