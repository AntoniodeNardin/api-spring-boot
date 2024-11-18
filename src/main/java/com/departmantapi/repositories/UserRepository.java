package com.departmantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departmantapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);

}
