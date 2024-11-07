// Интерфейс-репозиторий для товаров

package com.zspps.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zspps.store.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> 
{
    @Query("SELECT p FROM Product p ORDER BY id")
    List<Product> getAllProducts();

    @Query("SELECT p FROM Product p WHERE p.category_id = :category_id ORDER BY id")
    List<Product> findDataByCategoryId(@Param("category_id") int categoryId);
}