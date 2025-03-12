package com.example.dad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    @NonNull
    private String username;
    @Column(nullable = false, unique = true)
    @NonNull
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Character> characters;
}