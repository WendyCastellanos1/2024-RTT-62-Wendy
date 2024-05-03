package org.example;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

/*      Practical Application: you have a string, want to replace something in it,
        check something in it, but not so useful. introduced here at this point because
                some of the homeworks need you to capture custom input from the user
                to solve a problem. */

        //read input from the input stream
        Scanner sc1 = new Scanner (System.in);

        //read input from a string
        // .print  has no new line;  .println   includes new line
        System.out.print("Enter an number: ");
        int num1 = sc1.nextInt();

        System.out.print("The number is " + num1);

        sc1.close();
    }
}
