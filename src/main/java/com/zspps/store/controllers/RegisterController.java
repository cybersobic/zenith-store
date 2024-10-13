package com.zspps.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zspps.store.repositories.UserRepository;
import com.zspps.store.libs.Security;
import com.zspps.store.models.User;

@Controller
public class RegisterController
{
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/register")
    public String setTitle(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Zenith Софт - Регистрация");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        String hashedPassword = Security.getHashData(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return "register";
    }
}
