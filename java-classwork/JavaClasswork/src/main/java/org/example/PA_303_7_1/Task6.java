package org.example.PA_303_7_1;

public class Task6 {

    public static void main(String[] args) {

        //create an integer array of 5 numbers
        int[] myArray = new int[5];

        //loop. assign a value to each element: loop control variable x 2
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (i * 2);
            System.out.println(myArray[i]);     //prints 0  2  4  6  8
        }
    }
}
