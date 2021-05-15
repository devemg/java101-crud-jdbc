package com.devemg;

import com.devemg.data.dao.ProductDAO;

import java.util.Scanner;

public class HandlerProducts {
    private final ProductDAO product;

    public HandlerProducts() {
        this.product = new ProductDAO();
    }

    public int showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t PRODUCTS LIST ");
        System.out.println("------------------------------------------------------\n");
        System.out.println("1. Register new product");
        System.out.println("2. See all products");
        System.out.println("3. See single product");
        System.out.println("4. Update product");
        System.out.println("5. Delete product");
        System.out.println("6. Exit");
        return scanner.nextInt();
    }

    public void createProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's create a product!");
        System.out.println("Give me all the data and i'll create the product.");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Price: ");
        double price = scanner.nextDouble();
        System.out.println("Quantity: ");
        int qty = scanner.nextInt();
        System.out.println("Description: ");
        String desc = scanner.nextLine();
        System.out.println();
    }

}
