package com.codeup.SpringBlog.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
Post findByTitle(String title);
Post findFirstByTitle(String title);

}
