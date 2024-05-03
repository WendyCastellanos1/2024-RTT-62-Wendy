package org.example.PA_303_2_3;
import java.lang.Math;

public class OperatorsAndNumbers {
    public static void main(String[] args) {

        //Note: Tasks 5-7 completed (below)
        //      TODO: Tasks 1-4: it's too late at night to learn bitwise stuff!!

        //********Task 5************
            /* Write a program that declares an integer variable, assigns a number, and uses a
        postfix increment operator to increase the value. Print the value before and after the
        increment operator. */

        int g = 10;
        System.out.println("Before: " + g++); //prints value of g before the postfix increment
        System.out.println("After: " + g);

        //********Task 6************
                    /* Write a program that demonstrates at least three ways to increment a variable by 1
        and does this multiple times. Assign a value to an integer variable, print it, increment
        by 1, print it again, increment by 1, and then print it again. */

        int w = 0;
        System.out.println("Before: " + w++);
        System.out.println("AfterFirstIncrement: " + w); //1
        w = w + 1;
        System.out.println("AfterSecondIncrement: " + w); //2
        w +=1;
        System.out.println("AfterThirdIncrement: " + w); //3

        //********Task 7************
                /* Write a program that declares two integer variables: x, and y, and then assigns 5 to x
        and 8 to y. Create another variable sum and assign the value of ++x added to y, and
        print the result. Notice the value of the sum (should be 14). Now change the
        increment operator to postfix (x++) and re-run the program.
        Notice what the value of the sum is. The first configuration incremented x, and then calculated the sum, while
        the second configuration calculated the sum, and then incremented x. */

        int x = 5;
        int y = 8;
        int summation= y + ++x;
        System.out.println("Version 1 - Sum: " + summation); //14

        x = 5;
        y = 8;
        summation = y + x++;
        System.out.println("Version 2 - Sum: " + summation); //13

        //TODO
        //**********Task 1**********
        //
        // test with these values: 9, 17,  88
        //int x = 2;

        //System.Out.Println(Integer.toBinaryString(x));
        //use the left shift operator (<<) to shift by 1 and assign the result to x
        // x =           ;
        //The predicted decimal value is _ and predicted binary string is __

        //print x in decimal form
        //System.out.println(            );
        //print x in  binary notation
        //System.out.println(            );

        //********Task 2************
            /* Write a program that declares a variable x, and assigns 150 to it, and prints out the
        binary string version of the number. Now use the right shift operator (>>) to shift by 2
        and assign the result to x. Write a comment indicating what you anticipate the
        decimal and binary values to be. Now print the value of x and the binary string.
        Perform the preceding exercise with the following values: a. 225 b. 1555 c. 32456 */

        //********Task 3************
            /* Write a program that declares three int variables: x, y, and z. Assign 7 to x and 17 to y.
        Write a comment that indicates what you predict will be the result of the bitwise and
        operation on x and y. Now use the bitwise AND (&) operator to derive the decimal and
        binary values, and assign the result to z. */

        //********Task 4************
            /* Now, with the preceding values, use the bitwise and operator to calculate the “or”
        value between x and y. As before, write a comment that indicates what you predict
        the values to be before printing them out. */


    }
}
