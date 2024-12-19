package com.zspps.store.controllers;

import com.zspps.store.jwt.AuthResponse;
import com.zspps.store.jwt.JwtTokenService;
import com.zspps.store.libs.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zspps.store.services.UserService;

@RestController
@RequestMapping("/auth")
public class JwtTokenController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> AuthorizeJwtToken(@RequestBody LoginData loginData) {
        boolean isAuthenticated = userService.loginUser(loginData.getLogin(), loginData.getPassword());

        if(isAuthenticated) {
            String token = jwtTokenService.generateToken(loginData.getLogin());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        else {
            return ResponseEntity.status(401).body("Неверный логин или пароль");
        }
    }
}
