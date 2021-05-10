package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
