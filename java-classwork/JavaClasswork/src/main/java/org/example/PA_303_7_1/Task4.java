package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {

        //create an array with 5 integers
        int[] myArray = {10, 20, 30, 40, 50};

        //print the value at the first index
        System.out.println(myArray[0]);

        //print the value at the last index
        System.out.println(myArray[myArray.length - 1]);

        //produce an out-of-bounds exception by seeking a value at a non-existent index, one beyond the last element
        //System.out.println(myArray[myArray.length]);  //
        System.out.println("Using the length as an index produces:  java.lang.ArrayIndexOutOfBoundsException.");

        //to produce the same error
        //myArray[5] = 100;
        System.out.println("Index 5 out of bounds for length 5. Same error message as above.");
    }
}
