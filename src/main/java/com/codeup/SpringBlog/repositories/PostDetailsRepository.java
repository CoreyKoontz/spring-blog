package com.codeup.SpringBlog.repositories;

import com.codeup.SpringBlog.models.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
