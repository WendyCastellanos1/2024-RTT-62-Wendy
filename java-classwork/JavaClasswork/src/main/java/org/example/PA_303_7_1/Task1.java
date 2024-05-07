package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

        //declare in integer array with 3 elements
        int[] myArray = new int[3];

        //assign the values and immediately print the new value for the array element
        for (int pos = 0; pos < 3; pos++) {
            myArray[pos] = (pos + 20);
            System.out.println(myArray[pos]);
        }
    }
}
