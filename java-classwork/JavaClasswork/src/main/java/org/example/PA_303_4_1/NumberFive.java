package org.example.PA_303_4_1;

import java.util.Scanner;

/* Write a program that uses if-else-if statements to print out grades
       A, B, C, D, F, according to the following criteria:
       A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: <60
       Use the Scanner class to accept a number score from the user to
       determine the letter grade. Print out “Score out of range” if the score
       is less than 0 or greater than 100.
       MODIFICATIONS: 1. Upon wrong numeric input, the program explains error and *re-prompts* for input.
                      2. Error message specifies more detail on out-of-range.
                      3. Non-numeric "garbage" input ends the program.
                      4. Output shows both number and letter grade.
        */

public class NumberFive {

    public static void main(String[] args) {

        int grade = -333;           //for troubleshooting
        boolean outOfBounds = true; //init to out-of-bounds
        boolean hasGrade = false;  //init to no grade obtained (even if not validated yet)

        Scanner scanner = new Scanner(System.in);

        //loop until user inputs a valid grade (integer between 0 and 100, inclusive)
        do {
            //prompt the user
            System.out.print("Enter an integer grade between 0 and 100, inclusive: ");

            if (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    grade = scanner.nextInt();                          //capture the integer as the "grade"
                    hasGrade = true;                                    //user provided the grade
                } else {
                    //if bad data entered, e.g. "sdf" or other
                    System.out.println("Error: No integer found. Game over.");
                    break;  //prevents infinite loop!
                }
            }
            //validate grade, only if user entered it
            if (hasGrade) {
                if (grade < 0) {
                    //grade too low, out-of-bounds still true
                    System.out.println("Out-of-Range: Grade too low. You may not enter a \"negative\" grade\n");
                } else if (grade > 100) {
                    //grade too high, out-of-bounds still true
                    System.out.println("Out-of-Range: Grade too high. You may not enter a grade higher than 100\n");
                } else {
                    //grade is in range, exit loop next
                    outOfBounds = false;
                }
            }
        } while (outOfBounds); // true, if unchanged (loop), false, if valid grade (exit loop)

        scanner.close();

        if (hasGrade) {
            //Assign a grade, only if user entered it
            if (grade >= 90 && grade <= 100) {
                System.out.println("Your grade, " + grade + ", is an A.");
            } else if (grade >= 80 && grade < 90) {
                System.out.println("Your grade, " + grade + ", is a B.");
            } else if (grade >= 70 && grade < 80) {
                System.out.println("Your grade, " + grade + ", is a C.");
            } else if (grade >= 60 && grade < 70) {
                System.out.println("Your grade, " + grade + ", is a D.");
            } else if (grade < 60) {
                System.out.println("Your grade, " + grade + ", is an F.");
            }
        }
    }
}
