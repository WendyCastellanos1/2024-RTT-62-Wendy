package org.example.coffeeshop;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeShop {

    private List<Product> products = new ArrayList<>();

    public void initProducts(){

        Product smallCoffee = new Product();
        smallCoffee.setPrice(5.46);
        smallCoffee.setName("Small Coffee");
        smallCoffee.setBeverage((true));
        products.add(smallCoffee);

        Product largeCoffee = new Product();
        largeCoffee.setPrice(9.46);
        largeCoffee.setName("Large Coffee");
        largeCoffee.setBeverage((true));
        products.add(largeCoffee);

        Product cakePop = new Product();
        cakePop.setPrice(3.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Product eggSandwich = new Product(7.89, "Egg Sandwich", false);
        products.add(eggSandwich);

        //add the products from the csv file to the others above
        ProductReader pr = new ProductReader();
        List<Product> productsFromFile = pr.readProducts();
        products.addAll(productsFromFile);
    }

    //
    public void printCheapProducts(){

        //this code filters each of the products that is less than $5
        List<Product> cheapProducts = products.stream().filter(product -> product.getPrice() < 5).collect(Collectors.toList());

        //this code prints each of the products that is less than $5
        cheapProducts.forEach(product -> System.out.println(product.getName() + "\t" + product.getPrice())) ;
    }

    // print the list of products available for sale
    public void printProducts(){
        for (int pos = 0 ; pos < products.size(); pos++ ){
            Product product = products.get(pos);
            System.out.println((pos+1) + ") "  + product.getName() + "\t" + product.getPrice()  );
        }

        products.forEach(product -> {System.out.println(product.getName() +
                "/t" + product.getPrice());        });
    }
}