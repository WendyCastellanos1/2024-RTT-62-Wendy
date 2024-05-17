package org.example.PA_303_12_1;

import java.io.*;
import java.util.*;
import java.lang.*;

/*  You will be given two integers  and  as input, you have to compute .
If  and  are not  bit signed integers or if  is zero,
exception will occur and you have to report it.
Read sample Input/Output to know what to report in case of exceptions.
 Sample input you can type in the console:
 10 3   10  0   10 Hello  23.323 0*/

//public class Solution {
public class HR_ExceptionHandling {

    public static void main(String[] args)
            throws java.util.InputMismatchException, java.lang.ArithmeticException {

        Scanner scanner = new Scanner(System.in);

        int x = 0;
        int y = 0;

        //get x, but if not an int, then throw an exception
        try {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
            } else {
                throw new java.util.InputMismatchException("java.util.InputMismatchException");
            }
        } catch (java.util.InputMismatchException ex) {
            //exception code to show message
            System.out.println(ex.getMessage());
            scanner.close(); //we're done
            System.exit(0);
        }
        //get y, but if not an int, then throw an exception
        try {
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
            } else {
                throw new java.util.InputMismatchException("java.util.InputMismatchException");
            }
        } catch (java.util.InputMismatchException ex) {
            //exception code to show message
            System.out.println(ex.getMessage());
            scanner.close(); //we're done
            System.exit(0);
        }
        try {
            //if y is 0, throw exception
            if (y == 0) {
                throw new java.lang.ArithmeticException("java.lang.ArithmeticException: / by zero");
            } else {
                //divide
                System.out.println(x / y);
                scanner.close();
            }
        } catch (java.lang.ArithmeticException ex) {
            System.out.println(ex.getMessage());
            scanner.close();    //we're done
        }
    }
}

