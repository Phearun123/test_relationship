package com.example.test_relationship.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.id = ?1")
    Collection<Category> findCategoryById();
}
