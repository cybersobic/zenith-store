// Контроллер представления login.html

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
    // Зависимость UserService
    @Autowired
    private UserService userService;

    // Обработка Get-запросов для представления login
    @GetMapping("/login")
    public String GetLoginData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }

    // Обработка Post-запросов для представления login
    @PostMapping("/login")
    public String PostLoginData(@ModelAttribute User user, Model model)
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
