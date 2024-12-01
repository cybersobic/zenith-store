package com.zspps.store.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.zspps.store.models.Category;
import com.zspps.store.repositories.CategoryRepository;

@Controller
public class CatalogController
{
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/catalog")
    public String getCatalogPage(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Каталог товаров");

        List<Category> categoryData = categoryRepository.findAllCategoryData();
        model.addAttribute("categoryData", categoryData);

        return "catalog";
    }
}
