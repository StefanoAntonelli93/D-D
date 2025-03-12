package com.example.dad.repository;

import com.example.dad.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepo extends JpaRepository<Weapon, Long> {
    Optional<Weapon> findByName(String name);

    List<Weapon> findByLevel(Integer level);
}
