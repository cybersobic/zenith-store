// Контроллер представления favorites.html

package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoritesController 
{
    // Обработка Get-запросов для представления favorites
    @GetMapping("/favorites")
    public String GetFavoritesData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Избранное");
        return "favorites";
    }
}
