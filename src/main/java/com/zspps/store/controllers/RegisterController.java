package com.zspps.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zspps.store.repositories.UserRepository;
import com.zspps.store.libs.Security;
import com.zspps.store.models.User;

@Controller
public class RegisterController
{
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/register")
    public String setTitle(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Zenith Софт - Регистрация");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if(!checkLogins(user.getLogin())) {
            model.addAttribute("loginExistError", "Такой логин уже существует");
            return "register";
        }
        
        String hashedPassword = Security.getHashData(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return "register";
    }

    private boolean checkLogins(String login) {
        List<String> logins = userRepository.findAllLogins();
        for(String lg : logins) {
            if(lg.equals(login)) {
                return false;
            }
        }
        return true;
    }
}
