package org.example.coffeeshop;

public class Main {

    private CoffeeShop coffeeShop;

    public void printMenu(){
        System.out.println("0) Exit");
        System.out.println("1) Print the list of products");
        System.out.println("2) Order a product");
    }

    public void runCoffeeShop(){

        coffeeShop = new CoffeeShop();
        coffeeShop.initProducts();
        coffeeShop.printProducts();
    }
    //we have 1 public static void main for the whole  coffee shop project
    //this will be the way the project starts up
    public static void main(String[] args) {
        Main main = new Main();
        main.runCoffeeShop();
    }
}
