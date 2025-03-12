package com.example.dad.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_characters")
@Data
public class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true) // 255 default
    private String name;
    private Integer strength;
    private Integer life;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    // @AllArgsConstructor
    public GameCharacter(String name, Integer strength, Integer life) {
        this.name = name;
        this.strength = strength;
        this.life = life;
    }

    // @NoArgsConstructor
    public GameCharacter() {

    }

}