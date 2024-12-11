package com.zspps.store.controllers;

import com.zspps.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginDataController
{
    @Autowired
    private UserService userService;

    @GetMapping("/getUserData")
    public ResponseEntity<HashMap<String, String>> getUserData(@RequestParam(required = false) String login)
    {
        HashMap<String, String> userData = userService.getUserData(login);
        return ResponseEntity.ok(userData);
    }
}
