package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController
{
    @GetMapping("/catalog")
    public String getTitle(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Каталог товаров");
        return "catalog";
    }
}
