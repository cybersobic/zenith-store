package com.zspps.store.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zspps.store.models.User;
import com.zspps.store.services.UserService;

@Controller
public class LoginController
{
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Авторизация");
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Boolean> postLoginData(@RequestBody User user) {
        Map<String, Boolean> response = new HashMap<>();

        boolean loginStatus = userService.loginUser(user);

        response.put("loginStatus", loginStatus);

        System.out.println("Login status: " + loginStatus);
        
        return response;
    }
}
