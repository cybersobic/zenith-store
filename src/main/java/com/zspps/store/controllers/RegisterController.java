package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController
{
    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Регистрация");
        return "register";
    }
}
