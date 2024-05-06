package org.example.coffeeshop;

public class Product {

    //member variable, no exposure to outside without getters and setters
    private double price;
    private String name;
    private boolean beverage;

    //constructor (default)      (NOTE: no return type)
    public Product(){

    }

    //constructor (overloaded)   (NOTE: no return type)
    public Product(double price, String name, boolean beverage) {  //incoming versions of the vars
        this.price = price;     //this keyword delineates WHICH price
        this.name = name;
        this.beverage = beverage;
    }

    //generate setters and getters: menu: CODE > Generate > getters, ...setters, select fields
    //setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeverage(boolean beverage) {
        this.beverage = beverage;
    }

    //getters
    public String getName() {
        return name;
    }

    public boolean isBeverage() {
        return beverage;
    }

    public double getPrice() {
        return price;
    }





}
