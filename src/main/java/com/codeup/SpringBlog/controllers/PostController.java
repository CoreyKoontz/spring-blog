package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.PostDetails;
import com.codeup.SpringBlog.repositories.PostDetailsRepository;
import com.codeup.SpringBlog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    // Dependency Injection: --------------------------------
    private final PostRepository postDao;
    private final PostDetailsRepository postDetailsDao;

    public PostController(PostRepository postDao, PostDetailsRepository postDetailsDao) {
        this.postDao = postDao;
        this.postDetailsDao = postDetailsDao;
    }

    // ------------------------------------------------------ All Post

    @GetMapping("/post")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }

    // ------------------------------------------------------ Single post details
    // ----- ??? How can we create a seeder for post with foreign keys ??? -----
    @GetMapping("/post/{id}/show")
    public String viewPost(@PathVariable("id") long id, Model model) {
        Post post = postDao.getOne(id);
        PostDetails details = post.getPostDetails();
        model.addAttribute("post", post);
        if (details.isAwesome()){
            model.addAttribute("isAwesome", "Awesome!");
        } else {
            model.addAttribute("isAwesome", "Not so awesome");
        }
        return "post/show";
    }
    //(adsDao.getOne(1L).getAdDetails().getExtraStr())

    // ----------------------------------------------------------- Deleting a post

    @PostMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postDao.deleteById(id);
        return "redirect:/post";
    }

    // ------------------------------------------------------ Editing a post

    @GetMapping("post/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "post/edit";
    }

    @PostMapping("/post/{id}/edit")
    public String update(
            @PathVariable("id") long id,
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam Boolean isAwesome,
            @RequestParam String historyOfPost,
            @RequestParam String topicDescription) {
        Post postToUpdate = new Post(
                id,
                title,
                body,
                new PostDetails(isAwesome, historyOfPost, topicDescription));
        postDao.save(postToUpdate);
        return "redirect:/post";
    }


    // ------------------------------------------------------ Creating a post
    @GetMapping("/post/create")
    public String createPostForm() {
        return "post/create";
    }

    @PostMapping("/post/create")
    public String createPost(
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam Boolean isAwesome,
            @RequestParam String historyOfPost,
            @RequestParam String topicDescription) {
        Post postToInsert = new Post(
                title,
                body,
                new PostDetails(isAwesome, historyOfPost, topicDescription
                ));
        postDao.save(postToInsert);
        return "redirect:/post";
    }
}
