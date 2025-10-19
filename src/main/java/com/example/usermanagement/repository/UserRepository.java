package com.example.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.usermanagement.model.User;

// JpaRepository provides CRUD methods like save(), findAll(), deleteById()
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods like:
    boolean existsByEmail(String email);
}
