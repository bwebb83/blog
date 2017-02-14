package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 2/7/17.
 */

@Controller
public class HelloWorldController {


    @GetMapping("/contact")
    public String contactPage(){
        return "contact/form";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return formatGreeting(name);
    }

    private String formatGreeting(String name){
        return "<h1>Hello " + name + " from Spring!!</h1>";
    }

    @RequestMapping(path = "bye/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String bye(@PathVariable String name){
        return "<h1>Goodbye " + name + "! from Spring </h1>";
    }

    @GetMapping("/home")
    public String showDefault(Model model){
        List<String> names = new ArrayList<>();
        names.add("Fer");
        names.add("George");
        names.add("Robert");
        names.add("Brad");
        names.add("John");

        //passing all the attributes to my view using the model
        //this is an int
        model.addAttribute("age", 26);
        //this is a list
        model.addAttribute("names", names);
        //this is a string
        model.addAttribute("date", "Feb 7th");
        return"/home";

    }
}
