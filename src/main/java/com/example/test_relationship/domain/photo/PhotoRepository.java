package com.example.test_relationship.domain.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("select p from Photo p where p.id = ?1")
    Photo findPhotoById();
}
