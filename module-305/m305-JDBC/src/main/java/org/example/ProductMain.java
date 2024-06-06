package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
    // want to be able to search for a product
    //    1) be able to prompt user for a product
    //    2)     show the products and allow the user to select a product to modify
    //    2.5  use the id of the product the user just entered to do a query on the database
    //    3)     need to prompt the user to enter the new value quantity in stock
    //    4)     need to set the new quantity in stock on the product and save it to the database

    private ProductDAO productDAO = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // prompt the user to enter a product name
        String productName = inputProductSearch();

        //print the list of products
        List<Product> products = productDAO.findLikeName(productName);

        // print our product menu
        printProducts(products);

        // now validate the user enters a proper product id
        Product selectedProduct = null;
        while (selectedProduct == null) {
            //#2 print the list of products
            int productId = promptForProductId();

            //  2.5
            selectedProduct = productDAO.findById(productId);
            if (selectedProduct == null) {
                System.out.println("You have entered an invalid product id");
            }
        }
        //#3
        int quantity = promptQuantityInStock();
        System.out.println(quantity);

        //#4
        updateQuantityInStock(selectedProduct, quantity);
    }

    public void updateQuantityInStock(Product product, int quantity){
        product.setQuantityInStock((short) quantity);
        productDAO.update(product);
    }

    public int promptQuantityInStock(){
        // next SBA: really try to understand what is happening here. will need to do THIS error checking on SBA
        while (true){
            try {
                System.out.println("Enter the value for quantity in stock: ");
                int quantity = scanner.nextInt();
                return quantity;
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number: ");
            }
        }
    }

    public void printProducts(List<Product> products){
        //print
        System.out.println("ID | Product Name | Quantity in Stock");
        System.out.println("==========================================================");
        for ( Product product: products ) {
            System.out.println(product.getId() + " | "  + product.getProductName() + " | " + product.getQuantityInStock());
        }
        System.out.println("\n");
    }
    public int promptForProductId() {
        // validate for non-numeric or invalid numeric id, like not in db
        while (true) {
            try {
                System.out.print("/n Enter the product id to modify: ");
                int id = scanner.nextInt();
                return id;
            } catch (Exception e) {
                System.out.println("Please enter a valid number: ");
                scanner.nextLine();  //  SBA: to consume the  NEWLINE character SBA!!!!!!!!!!!!!!!!!!! .nextInt doesn't consume it!
            }
        }
    }

    public String inputProductSearch() {
        System.out.print("\nEnter a product name to search for: ");
        String productName = scanner.nextLine();
        return productName;
    }

    public static void main(String[] args) {
        ProductMain pm = new ProductMain();
        pm.run();
    }
}
