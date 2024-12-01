package com.zspps.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zspps.store.models.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {}