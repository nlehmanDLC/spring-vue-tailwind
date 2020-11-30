package com.nlehman.vuetailwind.models;

public class Product {
    /**
     *
     */
    public static final String FABRIC = "fabric";
    public static final String WALLCOVERING = "wallcovering";
    public static final String PRIVACY_CURTAIN = "privacyCurtains";
    private String name;
    private String image;
    private String category;

    public Product(String name) {
        this.setName(name);
        this.setCategory(FABRIC);
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
}
