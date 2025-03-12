package com.example.dad.entity;

import jakarta.persistence.*;
import lombok.Data;


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

    // @AllArgsConstructor
    public Weapon (String name, Integer level){
        this.name = name;
        this.level = level;
    }
    // @NoArgsConstructor
    public Weapon() {

    }
}
