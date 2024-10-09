package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title", "Zenith Софт - программное обеспечение для автоматизации производства");
        return "home";
    }
}
