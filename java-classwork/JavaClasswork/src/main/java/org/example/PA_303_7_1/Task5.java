package org.example.PA_303_7_1;

public class Task5 {

    public static void main(String[] args) {

        //create a new integer array with five elements
        int[] myArray = new int[5];

        //loop to assign each element with the value of the loop control variable
        for (int pos = 0; pos < myArray.length; pos++) {
            myArray[pos] = pos;
            System.out.println(myArray[pos]);
        }
    }
}
