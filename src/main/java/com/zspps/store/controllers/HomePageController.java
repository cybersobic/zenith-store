package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController
{
    @GetMapping("/")
    public String getHomePage(Model model)
    {
        model.addAttribute("title", "Zenith Store - Главная страница");
        return "home";
    }
}
