package com.codeup.SpringBlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String post() {
        return "post index page";
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id) {
        return "View post with id: " + id;
    }

    @GetMapping("/post/create")
    @ResponseBody
    public String createPostForm() {
        return "View form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "Post request to create a new post";
    }
}
