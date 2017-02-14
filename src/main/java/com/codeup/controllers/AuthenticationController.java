package com.codeup.controllers;

import com.codeup.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Brian on 2/13/17.
 */
@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
//        System.out.println(new BCryptPasswordEncoder().encode("codeup"));
        return "login";
    }

    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "users/create";
    }
}
