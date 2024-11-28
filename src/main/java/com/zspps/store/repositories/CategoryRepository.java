package com.zspps.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zspps.store.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> 
{
    @Query("SELECT c FROM Category c ORDER BY id")
    List<Category> findAllCategoryData();
}
