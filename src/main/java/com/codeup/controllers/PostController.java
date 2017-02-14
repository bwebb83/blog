package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
//import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 2/7/17.
 */
@Controller
public class PostController {
//    private PostSvc service;
//
//    @Autowired
//    public PostController(PostSvc service){
//        this.service=service;
//    }

    @Autowired
    Posts postDao;

    @GetMapping("/posts")
    public String post(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postid(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(@ModelAttribute Post post, Model model){
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post, Model model){
        User user = new User();
        user.setId(1L);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute Post post, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String saveEditPost(@PathVariable Long id, @ModelAttribute Post post, Model model){
        model.addAttribute("post", post);
        postDao.save(post);
        return "redirect:/posts";
    }
}


