package com.zspps.store.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zspps.store.libs.LoginData;
import com.zspps.store.libs.Security;
import com.zspps.store.models.User;
import com.zspps.store.repositories.UserRepository;

import java.util.List;

@Controller
public class LoginController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String setTitle(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }

    @PostMapping("/login")
public String loginUser(@ModelAttribute User user, Model model)
{
    List<LoginData> loginData = userRepository.findDataToLogin();
    String login = user.getLogin();
    String password = user.getPassword();

    for (LoginData lg : loginData) 
    {
        if (lg.getLogin().equals(login)) 
        {
            String hashedPassword = Security.getHashData(password);
            if (lg.getPassword().equals(hashedPassword)) 
            {
                return "redirect:/";
            } 
            else 
            {
                model.addAttribute("loginError", "Неверный пароль! Попробуйте еще раз.");
                return "login";
            }
        }
    }

    model.addAttribute("loginError", "Логин не найден! Попробуйте еще раз.");
    return "login";
}

}
