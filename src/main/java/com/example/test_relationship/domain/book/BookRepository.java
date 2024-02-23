package com.example.test_relationship.domain.book;

import com.example.test_relationship.domain.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {



}
