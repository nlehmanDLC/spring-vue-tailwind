package com.nlehman.vuetailwind.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    @JsonProperty
    private Long id;
    private String name;
    private String image;
    private String category;

    protected Product() {}

    public Product(String name) {
        this.name = name;
        this.category = com.nlehman.vuetailwind.models.Product.FABRIC;
    }

    @Override
    public String toString() {
        return String.format(
            "Product[id=%d, name='%s', image='%s', category='%s'",
            id, name, image, category);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
