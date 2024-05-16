package org.example;

public class KBA1Review {

    public static void main(String[] args) {

        //know how to make an array
        int[]  myArray = new int[12];
        int[] arr1; arr1 = new int[12];

        //description of the word static - make only one method in JVM. can use it without instantiation.
        //can be applied to class members. the members belong to the class, not the instance.
        //static keyword implies that the class members belong to the class, not an instance

        //autoboxing - compiler auto converts primitive value  converts to its wrapper class object

        //String buffer is mutable; String is not mutable

        //is a relationship related to inheritance

        //Inheritance: the ability by which one class acquires the properties and behaviors of another class

        //know the difference between class variable (the field /var at the class top) and local var (in fcn)

        //truncation is chopping off decimal value when casting (e.g. float) to an integer type

        //constructor has NO return type.

        //method overloading: name and number of arguments determined.

        //public static void main(String[] args) be able to pick something wrong
        //polymorphism the ability of variables & methods of object to take on multiple forms

        boolean bt = true;    //lower case! true and false are keywords.
        boolean bf = false;

        //an example tests inheritance understanding. what will the code do?
        //java does not support multiple inheritances
        //file extension of a java source code is java

        //which keywords for class declaration: public, private, abstract, class, extends, implements

        //protected: subclasses in OTHER packages, or any class within the same package

        //difference between ++y and y++   if its on its own line of code, doesn't matter, same
        //y++ does increment last,after use
        //mod % gives the remainder of the division    (for loop with mod, know continue and break)
        // continue skips any code after it and goes to the top of the  loop for next iteration
        //break - exit the loop immediately, and doesn't execute any code after break inside the loop;

        String a = "AFTER";
        String b = "BETA";
        String c = "CAPTURE";

        //know which version of the method gets called
        printOutput(a +  b + c);
        printOutput(a, b, c);

    }
    public static void printOutput(String output) {
        System.out.println(output);
    }
    public static void printOutput(String a, String b, String c){
        System.out.println(a + b + c);
    }
}