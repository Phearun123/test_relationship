package com.example.test_relationship.domain.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.id = ?1")
    Collection<Author> findAuthorById();
}
