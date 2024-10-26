// Контроллер представления basket.html

package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController 
{
    // Обработка Get-запросов для представления basket
    @GetMapping("/basket")
    public String GetBasketData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Корзина");
        return "basket";
    }
}
