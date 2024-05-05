package org.example.PA303_4_1;

import java.util.Scanner;

/* Write a program that accepts an integer between 1 and 7 from
        the user. Use a switch statement to print out the corresponding
        weekday. Print “Out of range” if the number is less than 1 or greater
        than 7. Do not forget to include “break” statements in each of your
        cases. */

public class NumberSix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numDay = -1;        //init to invalid value
        boolean out0fRange = true; //init flag to assume out-of-range

        //obtain a valid input from the user through unlimited prompts on the console
        do {
            System.out.println(("Enter a number between 1 and 7 for day-of-week."));
            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numDay = scanner.nextInt();
                } else {
                    System.out.println("Error: No integer found. Game over.");
                    break; //prevent infinite loop by exiting the loop [could code around this later]
                }
            }

            if (numDay >= 1 && numDay <= 7) {
                out0fRange = false;      //number valid, reset flag; loop will end at "while" condition
            } else {
                System.out.println("Number is out-of-range.");
            }
        } while (out0fRange);

        scanner.close();
        //print the day of the week based on the input
        switch (numDay) {
            case 1: {
                System.out.println("Monday");
                break;
            }
            case 2: {
                System.out.println("Tuesday");
                break;
            }
            case 3: {
                System.out.println("Wednesday");
                break;
            }
            case 4: {
                System.out.println("Thursday");
                break;
            }
            case 5: {
                System.out.println("Friday");
                break;
            }
            case 6: {
                System.out.println("Saturday");
                break;
            }
            case 7: {
                System.out.println("Sunday");
                break;
            }
            default: {
                //pre-validation handled out-of-bounds, so handle unknown exception
                System.out.println("Run the program again and only enter an integer.");
            }
        }
    }
}
