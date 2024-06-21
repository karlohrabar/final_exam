package com.hrabar.project.controller;

import com.hrabar.project.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class AuthController {
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        var user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    
}
