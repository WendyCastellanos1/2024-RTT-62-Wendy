package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        //declare the original array, adding the elements
        String[] firstArray = {"red", "green", "blue"};

        //print the lenth of the original array
        System.out.println("The size of the original array is: " + firstArray.length);

        //print the contents of the original array
        System.out.println("Original array contains: " + Arrays.toString(firstArray));

        //clone the original array to a new array
        String[] secondArray = firstArray.clone();  //now, two separate  object instances on the heap

        //print the contents of the clone
        System.out.println("Cloned array contains: " + Arrays.toString(secondArray));
    }
}
