// Интерфейс-репозиторий для категорий товаров

package com.zspps.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zspps.store.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> 
{
    // Выборка всех названий категорий
    @Query("SELECT c.name FROM Category c")
    List<String> findAllCategoryNames();
}
