package com.zspps.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.zspps.store.models.User;
import com.zspps.store.services.UserService;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String setTitle(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model)
    {
        if(userService.loginUser(user))
        {
            return "redirect:/";
        }
        else
        {
            return "/login";
        }
        
    }
}
