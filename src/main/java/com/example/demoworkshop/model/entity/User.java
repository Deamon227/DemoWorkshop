package com.example.demoworkshop.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String status;
    private String location;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}