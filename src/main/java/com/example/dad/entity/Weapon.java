package com.example.dad.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(
        name = "weapon",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "level"})
)
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer level;

    @OneToMany(mappedBy = "weapon")
    private List<Character> characters;

    // @AllArgsConstructor
    public Weapon (String name, Integer level){
        this.name = name;
        this.level = level;
    }
    // @NoArgsConstructor
    public Weapon() {

    }
}
