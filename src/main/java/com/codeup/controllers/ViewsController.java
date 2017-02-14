package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by Brian on 2/7/17.
 */
@Controller
public class ViewsController {

    @GetMapping("/resume")
    public String showResume(){
        return "/resume";
    }

    @GetMapping("/roll-dice")
    public String main(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String main(@PathVariable int n, Model model){
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;

        model.addAttribute("roll", roll);
        model.addAttribute("n", n);

        return "guess";
    }



}
