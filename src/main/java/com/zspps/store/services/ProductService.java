package com.zspps.store.services;

import java.util.List;
import com.zspps.store.libs.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.zspps.store.models.Product;
import com.zspps.store.repositories.ProductRepository;

@Service
public class ProductService 
{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(Integer categoryId)
    {
        Specification<Product> specification = Specification.where(null);

        if(categoryId != null && categoryId != 0)
        {
            specification = specification.and(ProductSpecification.categoryFilter(categoryId));
        }

        Sort sort = Sort.by(Sort.Direction.ASC, "categoryId");

        int pageNumber = 0;
        int pageSize = getAllProductsCount();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return productRepository.findAll(specification, pageable).getContent();
    }

    public Integer getAllProductsCount()
    {
        return (int) productRepository.count();
    }
}
