package com.example.dad.repository;

import com.example.dad.entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameCharacterRepo extends JpaRepository<GameCharacter, Long> {
    List<GameCharacter> findByUser_Username(String username);

    List<GameCharacter> findByUserId(Long userId);

    Optional<GameCharacter> findByName(String name);

    List<GameCharacter> findByStrength(Integer strength);
}
