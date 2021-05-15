package com.devemg;

public class Main {

    public static void main(String[] args) {
        HandlerProducts handlerProducts = new HandlerProducts();
        int option = 6;
        do {
            option = handlerProducts.showMenu();
            switch (option) {
                case 1: // create product
                    handlerProducts.createProduct();
                    break;
                case 2: //list products
                    break;
                case 3: //see single product
                    break;
                case 4: //update product
                    break;
                case 5: //delete product
                    break;
                default:
                    System.out.println("Option "+option+" not found");
            }
        } while (option!=6);
    }


}
