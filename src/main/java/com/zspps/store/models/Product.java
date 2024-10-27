// Класс-модель товара

package com.zspps.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "price")
    private int price;

    @Column(name = "description", length = 700)
    private String description;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCategoryId(int category_id) 
    {
        this.category_id = category_id;
    }

    public int getCategoryId() 
    {
        return category_id;
    }

    public void setPrice(int price) 
    {
        this.price = price;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
}
