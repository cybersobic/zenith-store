// Интерфейс-репозиторий для товаров

package com.zspps.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zspps.store.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}