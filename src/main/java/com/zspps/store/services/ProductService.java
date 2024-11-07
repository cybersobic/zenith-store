// Класс-сервис с бизнес-логикой для Product

package com.zspps.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zspps.store.models.Product;
import com.zspps.store.repositories.ProductRepository;

@Service
public class ProductService 
{
    // Зависимость ProductRepository
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(Integer categoryId) 
    {
        if (categoryId == null || categoryId == 0) 
        {
            return productRepository.getAllProducts();
        }

        return productRepository.findDataByCategoryId(categoryId);
    }
}
