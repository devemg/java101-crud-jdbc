package com.devemg;

import com.devemg.data.MysqlConnection;
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
        System.out.println("6. Config database");
        System.out.println("7. Exit");
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

    public void showOne() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's see a product!");
            System.out.println("Give me an id of any product and I'll show it");
            int id = scanner.nextInt();
            Product product = productDao.select(id);
            scanner.nextLine(); //consume \n
            if(product != null) {
                System.out.println(product);
            }else {
                System.out.println("Product not found");
            }
            scanner.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's update a product!");
            System.out.println("Give me all the data to update the product.");
            System.out.println("Id of product: ");
            int id = scanner.nextInt();
            scanner.nextLine(); //consume \n
            Product product = productDao.select(id);
            if(product != null) {
                System.out.print("Name["+product.getName()+"]:");
                String name = scanner.nextLine();
                System.out.print("Price["+product.getprice()+"]:");
                double price = scanner.nextDouble();
                scanner.nextLine(); //consume \n
                System.out.print("Quantity["+product.getQuantity()+"]:");
                int qty = scanner.nextInt();
                scanner.nextLine(); //consume \n
                System.out.print("Description["+product.getDescription()+"]:");
                String desc = scanner.nextLine();
                if(!name.equals("")){
                    product.setName(name);
                }
                if(!desc.equals("")){
                    product.setDescription(name);
                }
                product.setprice(price);
                product.setQuantity(qty);
                int result = productDao.update(product);
                if(result > 0) {
                    System.out.println("product updated!");
                }else {
                    System.out.println("product not updated");
                }
            }else {
                System.out.println("Product not found");
            }
            scanner.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's delete a product!");
            System.out.println("Give me an id of any product and I'll delete it");
            int id = scanner.nextInt();
            int result = productDao.delete(id);
            scanner.nextLine(); //consume \n
            if(result > 0) {
                System.out.println("Product deleted!");
            }else {
                System.out.println("Product not found");
            }
            scanner.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void updateDatabase() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's update the database config!");
            System.out.println("Give me all the data to update database connection.");
            System.out.print("Host["+ MysqlConnection.getHost() +"]:");
            String host = scanner.nextLine();
            System.out.print("Port["+MysqlConnection.getPort()+"]:");
            String port = scanner.nextLine();
            System.out.print("Database["+ MysqlConnection.getDatabase() +"]:");
            String database = scanner.nextLine();
            System.out.print("User["+MysqlConnection.getUser()+"]:");
            String user = scanner.nextLine();
            System.out.print("Password:");
            String password = scanner.nextLine();
            // update info
            if(!host.equals("")){
                MysqlConnection.setHost(host);
            }
            if(tryParseInt(port) && !port.equals("")){
               MysqlConnection.setPort(Integer.parseInt(port));
            }
            if(!database.equals("")){
                MysqlConnection.setDatabase(database);
            }
            if(!user.equals("")){
                MysqlConnection.setDatabaseUser(user);
            }
            //password can be empty
            MysqlConnection.setDatabasePassword(password);
            //reload connection with database
            MysqlConnection.reloadStringConnection();
            // show changes
            //System.out.println(MysqlConnection.getConnectionString());
            //System.out.println(MysqlConnection.getUser());
            //System.out.println(MysqlConnection.getPassword());
            System.out.println("database information was updated!");
            scanner.nextLine();
        }catch (InputMismatchException ex) {
            System.out.println("oh no! the input was type wrong.\n come back and try again.");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public boolean tryParseInt(String value) {
        try {
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
