package org.example.GLAB_303_5_1;

public class SumNaturalNumbers {
    public static void main(String[] args) {

        int sum = 0;
        int n = 1000;

        //for loop
        for (int i = 1; i <= n; ++i) {       // prefix increment happens *top* of second time through loop
            System.out.println(i);          // prints 1 - 1000
            sum += i;                      // sum = sum + 1
        }
        System.out.println("Sum = " + sum);     // Sum is 500500
    }
}
