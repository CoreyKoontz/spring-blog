package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/post")
    public String post(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "title1", "body1"));
        posts.add(new Post(2, "title2", "body2"));
        posts.add(new Post(3, "title3", "body3"));
        model.addAttribute("posts", posts);
        return "post/index";
    }

    // Need a getById method and DB to actually show the post details?
    // Tried passing the post object as a path variable but didnt work.
    @GetMapping("/post/show/{id}")
    public String viewPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        Post post = new Post(id, "showTitleText", "showBodyTest");
        model.addAttribute("post", post);
        return "post/show";
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
