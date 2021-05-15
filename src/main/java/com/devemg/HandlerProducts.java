package com.devemg;

import com.devemg.data.dao.ProductDAO;
import com.devemg.data.entities.Product;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HandlerProducts {
    private final ProductDAO productDao;

    public HandlerProducts() {
        this.productDao = new ProductDAO();
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
        try {
            System.out.println("Let's create a product!");
            System.out.println("Give me all the data and I'll create the product.");
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Price: ");
            double price = scanner.nextDouble();
            System.out.println("Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Description: ");
            String desc = scanner.nextLine();

            int insert = this.productDao.insert(new Product(name,price,qty,desc));
            if(insert > 0) {
                System.out.println("Product created!");
            }else {
                System.out.println("oh no! product can't be created");
            }
            scanner.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void showAll() {
        System.out.println("Let's list all products!");
        List<Product> products = this.productDao.selectAll();
        products.forEach(System.out::println);
        new Scanner(System.in).nextLine();
    }
}
