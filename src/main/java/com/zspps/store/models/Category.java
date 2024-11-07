// Класс-модель категории товара

package com.zspps.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "image_link", length = 70)
    private String imageLink;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setImageLink(String imageLink)
    {
        this.imageLink = imageLink;
    }

    public String getImageLink() 
    {
        return imageLink;
    }
}
