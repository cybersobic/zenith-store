package com.zspps.store.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zspps.store.models.Category;
import com.zspps.store.models.Product;
import com.zspps.store.repositories.CategoryRepository;
import com.zspps.store.services.ProductService;

@Controller
public class CatalogController
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/catalog")
    public String getCatalogPage(Model model)
    {
        model.addAttribute("title", "Zenith Софт - Каталог товаров");

        List<Category> categoryData = categoryRepository.findAllCategoryData();
        System.out.println(categoryData);
        model.addAttribute("categoryData", categoryData);

        return "catalog";
    }

    @GetMapping("/catalog/products")
    @ResponseBody
    public List<Product> getCatalogRestData(@RequestParam(value = "categoryId", required = false) Integer categoryId) 
    {
        List<Product> products = productService.getProductsByCategory(categoryId);
        return products;
    }
}
