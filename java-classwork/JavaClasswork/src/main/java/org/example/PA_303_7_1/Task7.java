package org.example.PA_303_7_1;

public class Task7 {

    public static void main(String[] args) {

        //create an integer array of 5 numbers
        int[] myArray = new int[5];

        //calculate the index of the middle element
        int middleElementIndex = myArray.length / 2;

        //loop. assign a value to each element: loop control variable x 100
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (i * 100);
            //print ONLY IF NOT the middle element
            if (i != middleElementIndex) {
                System.out.println(myArray[i]);     //prints 0  100  300  400  (skips 200)
            }
        }

    }
}
