package org.example.PA_303_9_1.HR_JavaInheritance2;

public class Solution {

    public static void main(String[] args) {

        Adder myAdder = new Adder();

        //get parent class name and print
        Class<?> superClass = myAdder.getClass().getSuperclass();
        System.out.println("My superclass is: " +  superClass.getName());

        //sum and print (in HackerRank: locked code stub calls the add method 3x)
        System.out.print(myAdder.add(40,2) + " ");
        System.out.print(myAdder.add(10,3) + " ");
        System.out.print(myAdder.add(8,12) + " ");
    }
}
