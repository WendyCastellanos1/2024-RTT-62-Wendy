package org.example.PA_303_7_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task9 {

    //write a program to sort the int array asc order. print in asc order, smallest element, largest element

    public static void main(String[] args) {

        int minInt = 0;
        int maxInt = 0;
        int[] myArray = {4, 2, 9, 13, 1, 0};

        //order the elements of the array in ascending order
        Arrays.sort(myArray);
        for (int pos = 0; pos < myArray.length; pos++) {
            if (pos == 0) {
                minInt = myArray[pos];
            }
            if (pos == myArray.length - 1) {
                maxInt = myArray[pos];
            }
        }
        //print the array, ordered asc
        System.out.println(Arrays.toString(myArray));

        //print the smallest and biggest numbers
        System.out.println(minInt);
        System.out.println(maxInt);
    }
}
