package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController
{
    @GetMapping("/info")
    public String getInfoPage(Model model)
    {
        model.addAttribute("title", "Информация о товаре");
        return "info";
    }
}
