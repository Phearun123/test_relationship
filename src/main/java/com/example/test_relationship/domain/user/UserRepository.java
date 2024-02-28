package com.example.test_relationship.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = ?1")
    Optional<User> findUserByUserName(String username);

    @Query("select u from User u where u.id = ?1")
    Optional<User> findByUserId(Long id);
}
