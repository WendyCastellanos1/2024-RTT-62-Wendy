package org.example.PA_303_5_1;

import java.util.Scanner;

/* ❖ Write a program that prompts the user to enter two positive
integers, and find their greatest common divisor (GCD).
❖ Examples:
➢ Enter 2 and 4. The gcd is 2.
➢ Enter 16 and 24. The gcd is 8.
❖ How do you find the gcd?
➢ Name the two input integers n1 and n2.
➢ You know number 1 is a common divisor, but it may not be
the gcd.
➢ Check whether k (for k = 2, 3, 4, and so on) is a common
divisor for n1 and n2, until k is greater than n1 or n2. */

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        int n1 = -1;
        int n2 = -1;
        boolean isInvalid_n1 = true;
        boolean isInvalid_n2 = true;
        int gcd = 1;

        Scanner scanner = new Scanner(System.in);

        //Loop to fetch the input, validate, and re-prompt if any negative integers; //TODO exit if non-integers
        do {
            //prompt user to enter two integers
            System.out.println("\nEnter two POSITIVE integers, separated by at least one space (example: 12 13)");

            //get first integer
            if (scanner.hasNext()) {
                n1 = scanner.nextInt();

                //get second integer (if not entered, program just waits for it, "forever."  Countdown timer?)
                if (scanner.hasNext()) {
                    n2 = scanner.nextInt();
                }
            } else {
                System.out.println("There is no first integer. Game over.");
                break;
            }

            //reset the flags in case of re-prompt
            isInvalid_n1 = true;
            isInvalid_n2 = true;

            //check if integers are positive
            if (n1 >= 0) {
                isInvalid_n1 = false;
            } else {
                System.out.println("Error: Your first integer is negative.");
            }
            if (n2 >= 0) {
                isInvalid_n2 = false;
            } else {
                System.out.println("Error: Your second integer is negative.");
            }

        } while ((isInvalid_n1) || (isInvalid_n2)); //start over and get new input

        //with two, valid, positive integers, find the gcd
        for (int k = 1; (k <= n1 && k <= n2); k++) {
            if ((n1 % k == 0) && (n2 % k == 0)) {      //does k divide into both integers with no remainder?
                gcd = k;                               //it does, so update gcd
            }
        }
        System.out.println("\nThe greatest common divisor of " + n1 + " and " + n2 + " is " + gcd);

        scanner.close();
    }
}
