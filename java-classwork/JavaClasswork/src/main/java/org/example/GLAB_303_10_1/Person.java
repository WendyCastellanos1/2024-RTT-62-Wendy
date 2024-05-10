package org.example.GLAB_303_10_1;
public class Person {
    //class variables
    String name;
    static int lifeSpan = 60;
    static double ageFactor = 1.0;

    //default constructor
    public Person() {
        name = "";
    }
    //constructor with one argument
    public Person(String aName) {
        name = aName;
    }
    //getter and setter
    public String getName() { return name; }
    public void setName(String aName) { name = aName; }

    //4 class methods that have return values
    public String toString() {
        return("Hello, my name is " + name);
    }
    public String talk() {
        return("I have nothing to say.");
    }
    public String walk() {
        return("I have nowhere to go.");
    }
    public static double lifeSpan() {
        return(lifeSpan * ageFactor);
    }
}
