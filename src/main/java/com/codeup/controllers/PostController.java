package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Brian on 2/7/17.
 */
@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String post(){
        return "<h1>Posts index page</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postid(@PathVariable int id){
        return "<h1>View an individual post</h1>";
    }



    @RequestMapping(path = "/posts/create", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String create(){
        return "<h1>View the form for creating a post and create a new post.</h1>";
    }
}
