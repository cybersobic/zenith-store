package com.zspps.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.zspps.store.services.UserService;
import com.zspps.store.models.User;

@Controller
public class RegisterController
{
    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String GetRegisterData(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Zenith Софт - Регистрация");
        return "register";
    }

    @PostMapping("/register")
    public String PostRegisterData(@ModelAttribute User user)
    {
        userService.registerUser(user);
        return "redirect:/login";
    }
}
