package com.example.usermanagement.model;

import jakarta.persistence.*;
import lombok.*;

// @Entity maps this class to a database table
@Entity
@Data // Generates getters, setters, toString, equals, hashCode (via Lombok)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") // Table name in MySQL
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role; // e.g. "Admin" or "User"
}
