package com.zspps.store.controllers;

import com.zspps.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginDataController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserData")
    public ResponseEntity<Map<String, String>> getUserData(@RequestParam(required = false) String login) {
        Map<String, String> userData = userService.getUserData(login);
        return ResponseEntity.ok(userData);
    }
}
