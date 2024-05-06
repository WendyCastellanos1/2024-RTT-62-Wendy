package org.example.Homework_303_7_1;

import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

public class HomeworkArrays {

    public static void main(String[] args) {

        //initialize an array of integers with 10 elements
        int[] randomArray = new int[10];

        //prep class level variables to be accessible outside of the  loop
        int minValue = 0;
        int maxValue = 0;
        int sum = 0;
        double average;

        //initialize the array to random integers
        for(int counter = 0; counter < randomArray.length ; counter++){           // randomArray.length

            //generate a random integer
            // instantiate a  Random object
            Random random = new Random();
            //generate a random number from 0 to 100
            randomArray[counter] =  random.nextInt(100);   //greater than or equal to zero and less than 100

            //get the smallest integer in the array
            if (counter == 0){
                //first run, init minValue with the first integer
                minValue = randomArray[0];
            }
            if (randomArray[counter] < minValue){
                minValue = randomArray[counter];    //swap current element's value into minValue if its smaller
            }

            //get the largest integer in the array
            if (counter == 0){                      //init maxValue with the first integer
                maxValue = randomArray[0];
            }
            if (randomArray[counter] > minValue) {
                maxValue = randomArray[counter];    //swap current element's value into minValue if its larger
            }
            //get the cumulative sum by adding the current element's value
            sum = sum + randomArray[counter];
        }
        //calculate the average of the random integers as double
        average = ((double)sum / (double)randomArray.length);

        //print the results
        System.out.println("The minimum value is " + minValue + ".");
        System.out.println("The maximum value is " + maxValue + ".");
        System.out.println("The average value is " + average+ ".");
    }
}
