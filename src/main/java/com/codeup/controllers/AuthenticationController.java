package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Brian on 2/13/17.
 */
@Controller
public class AuthenticationController {
    private UsersRepository repository;
    private PasswordEncoder encoder;



    @Autowired
    public AuthenticationController(UsersRepository repository, PasswordEncoder encoder){
        this.repository=repository;
        this .encoder=encoder;
    }
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

    @PostMapping("/users/create")
    public String registerUser(@Valid User user, Errors validation, Model model){
        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/create";
        }

        String hashedPassword = encoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        repository.save(user);
        return "redirect:/login";

    }
}
