package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
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

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    // ------------------------------------------------------

    @GetMapping("/post")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }


    @GetMapping("/post/{id}/show")
    public String viewPost(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "post/show";
    }

    // Deleting a post -----------------------------------------------------------

    @PostMapping("/post/{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postDao.deleteById(id);
        return "redirect:/post";
    }

    // Editing a post ------------------------------------------------------------

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
            @RequestParam String body){
        Post postToUpdate = new Post(id, title, body);
        postDao.save(postToUpdate);
        return "redirect:/post";
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
