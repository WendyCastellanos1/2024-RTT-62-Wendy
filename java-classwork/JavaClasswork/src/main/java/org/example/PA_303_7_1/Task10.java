package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task10 {

    public static void main(String[] args) {

        //declare variables to hold the diverse values
        int num1 = 50;
        String s1 = "Stargate SG1";
        String s2 = "Stargate Atlantis";
        String s3 = "Stargate: Some Movie";
        double d1 = 2.33;

        //create an object array to hold 5 elements
        Object[] myArray = {num1, s1, s2, s3, d1};

        //print the array
        System.out.println(Arrays.toString(myArray));
    }
}
