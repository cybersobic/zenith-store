package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String setTitle(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }
}
