package org.example.PA_303_7_1;

public class Task8 {

    public static void main(String[] args) {

        //create a string array of 5 elements
        String[] myArray = new String[5];

        for (int i = 0; i < 5; i++) {
            myArray[i] = i + " dogs";
        }
        //swap the first and middle elements
        String temp = myArray[0];
        myArray[0] = myArray[myArray.length - 1];
        myArray[myArray.length - 1] = temp;

        //print using current values, but correct history
        System.out.println("The first element was " + myArray[myArray.length - 1] + " and is now " + myArray[0] + ".");
        System.out.println("The last element was " + myArray[0] + " and is now " + myArray[myArray.length - 1] + ".");

    }
}
