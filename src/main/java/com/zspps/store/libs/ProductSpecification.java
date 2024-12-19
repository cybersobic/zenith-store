package com.zspps.store.libs;

import com.zspps.store.models.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> categoryFilter(Integer categoryId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoryId"), categoryId);
    }
}
