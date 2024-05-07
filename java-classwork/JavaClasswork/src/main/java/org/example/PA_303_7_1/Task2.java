package org.example.PA_303_7_1;

public class Task2 {
    public static void main(String[] args) {

        //output will show twice because I wrote two ways to obtain it :)

        //create a new integer array, assigning values
        int[] myArray = {13, 5, 7, 68, 2};

        //easy way to get the middle element
        System.out.println("Using the index: " + myArray[2]);

        //fun way to get the middle element
        int middleElement = myArray.length / 2;     //auto-rounds up, giving the middle element's index
        System.out.println("Using the formula: " + myArray[middleElement]);
    }

}
