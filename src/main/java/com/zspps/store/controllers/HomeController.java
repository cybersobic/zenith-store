// Контроллер представления home.html

package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    // Обработка Get-запросов для представления home
    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Главная страница");
        return "home";
    }
}
