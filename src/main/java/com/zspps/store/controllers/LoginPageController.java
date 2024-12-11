package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController
{
    @GetMapping("/login")
    public String getLoginData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }
}
