package org.example.PA_303_12_1;

/* Create a class MyCalculator which consists
of a single method long power(int, int).
This method takes two integers,  and ,
as parameters and finds .
If either  or  is negative,
then the method must throw an exception which says
 "n or p should not be negative."
 also, if n and p are zero, then the method
 must throw an exception which says,
 "n and p should not be zero"
* */

//TODO all test cases pass in IntelliJ, 2nd test case works here but not in HR

import java.io.*;
import java.util.*;
import java.lang.Math;

public class MyCalculator {

    public long power(int n, int p) {

        long result = -1;

        try{

            if ((n < 0) || (p < 0)){
                throw new Exception("java.lang.Exception: n or p should not be negative.");

            }else if ((n == 0) && (p == 0)){
                throw new Exception("java.lang.Exception: n and p should not be zero.");

            }else{
                result = ((long)Math.pow((double)n, (double)p));
            }

        }catch(Exception e){

            System.out.println(e.getMessage());
        }
        return result;
    }
}