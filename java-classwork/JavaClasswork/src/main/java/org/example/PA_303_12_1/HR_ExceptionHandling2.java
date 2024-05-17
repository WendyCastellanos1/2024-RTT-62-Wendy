package org.example.PA_303_12_1;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class HR_ExceptionHandling2 {

        public static void main(String[] args) {

            int n = 0;
            int p = 0;

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                }
                if (scanner.hasNextInt()) {
                    p = scanner.nextInt();
                }
                scanner.nextLine();  //consume the newLine character

                MyCalculator calculator = new MyCalculator();

                long result = calculator.power(n, p);
                if (!(result==-1)){
                    System.out.println(result);
                }

                n = 0; //re-initialize
                p = 0;
            }
            scanner.close();
        }
    }

