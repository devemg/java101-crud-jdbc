package com.devemg.ShopList.entities;

import com.sun.source.util.SimpleTreeVisitor;

public class Product {
    private int idProduct;
    private String name;
    private double budget;
    private int quantity;
    private String image;
    private String description;

    public Product(){

    }

    /**
     * Delete product
     * @param idProduct
     */
    public Product(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Create Product
     * @param name
     * @param budget
     * @param quantity
     * @param image
     * @param description
     */
    public Product(String name, double budget, int quantity, String image,
                   String description){
        this.name = name;
        this.budget = budget;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    /**
     * Show product
     * @param idProduct
     * @param name
     * @param budget
     * @param quantity
     * @param image
     * @param description
     */
    public Product(int idProduct,String name, double budget, int quantity, String image,
                   String description){
        this.idProduct = idProduct;
        this.name = name;
        this.budget = budget;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct:" + idProduct +
                ", name:'" + name + '\'' +
                ", budget:" + budget +
                ", quantity:" + quantity +
                ", image:'" + image + '\'' +
                ", description:'" + description + '\'' +
                '}';
    }
}

