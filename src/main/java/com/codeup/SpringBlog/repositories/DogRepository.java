package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
