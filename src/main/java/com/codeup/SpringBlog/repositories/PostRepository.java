package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {

}
