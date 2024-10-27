// Контроллер представления catalog.html

package com.zspps.store.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zspps.store.models.Product;
import com.zspps.store.repositories.CategoryRepository;
import com.zspps.store.repositories.ProductRepository;

@Controller
public class CatalogController
{
    // Зависимость CategoryRepository
    @Autowired
    private CategoryRepository categoryRepository;

    // Зависимость ProductRepository
    @Autowired
    private ProductRepository productRepository;

    // Обработка Get-запросов для представления catalog
    @GetMapping("/catalog")
    public String GetCatalogData(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Каталог товаров");

        List<String> categoryNames = categoryRepository.findAllCategoryNames();
        System.out.println(categoryNames);
        model.addAttribute("categories", categoryNames);
        
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        model.addAttribute("products", products);

        return "catalog";
    }
}
