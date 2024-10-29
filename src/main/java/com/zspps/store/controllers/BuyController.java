// Контроллер представления buy.html

package com.zspps.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyController
{
    // Обработка Get-запросов для представления buy
    @GetMapping("/buy")
    public String GetBuyData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Покупка");
        return "buy";
    }
}
