package com.example.dad.service;

import com.example.dad.entity.Weapon;
import com.example.dad.repository.WeaponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {
    private final WeaponRepo repo;

    public WeaponService(@Autowired WeaponRepo repo) {
        this.repo = repo;
    }

    public List<Weapon> getAllWeapon() {
        return repo.findAll();
    }

    public Optional<Weapon> getWeaponByName(String name) {
        return repo.findByName(name);
    }

    public List<Weapon> getWeaponByLevel(Integer level) {
        return repo.findByLevel(level);
    }

    public void addWeapon(Weapon weapon) {
        repo.save(weapon);
    }

    public void deleteWeapon(Long id) {
        repo.deleteById(id);
    }
}
