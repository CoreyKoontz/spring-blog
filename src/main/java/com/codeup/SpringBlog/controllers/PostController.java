package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Post;
import com.codeup.SpringBlog.models.PostDetails;
import com.codeup.SpringBlog.models.User;
import com.codeup.SpringBlog.repositories.PostDetailsRepository;
import com.codeup.SpringBlog.repositories.PostRepository;
import com.codeup.SpringBlog.repositories.UserRepository;
import com.codeup.SpringBlog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // -------------------------------- Dependency Injection
    private final PostRepository postDao;
    private final PostDetailsRepository postDetailsDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, PostDetailsRepository postDetailsDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.postDetailsDao = postDetailsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    // ------------------------------------------------------ View all Post

    @GetMapping("/post")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }

    // ------------------------------------------------------ View single post details

    @GetMapping("/post/{id}/show")
    public String viewPost(@PathVariable("id") long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);

        if (post.getPostDetails().getIsAwesome()) {
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
    public String createPostForm(Model model) {
//        model.addAttribute("post", new Post()); // added this for form model binding
        model.addAttribute("postDetails", new PostDetails());
        return "post/create";
    }

    @PostMapping("/post/create")
    public String createPost(
            @ModelAttribute PostDetails postDetails,
            @RequestParam String title,
            @RequestParam String body
    ) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToInsert = new Post(
                title,
                body,
                postDetails,
                user
        );
        postDao.save(postToInsert);
        emailService.prepareAndSend( postToInsert, title, body);
        return "redirect:/post";
    }
}
