package org.example;
import java.lang.Math;
import java.text.DecimalFormat;

public class Homework303_2_1{

    public static void main(String[] args) {
        //int example: declare two int vars, assign value to each; sum to var, print result.
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println("\nThe sum of " + num1 + " and " + num2 + " =  " + sum);

        //double example
        double dNum1 = 20.7d;
        double dNum2 = 20.3d;
        double dSum = dNum1 + dNum2;
        System.out.println("\nThe sum of " + dNum1 + " and " + dNum2 + " is " + dSum);

        //int plus double example
        int number1 = 10;
        double number2 = 10.8d;
        double newSum = number1 + number2;
        System.out.println("\nThe sum of " + number1 + " and " + number2 + " =  " + newSum);

        //two ints...divide larger by smaller
        int largerNum = 100;
        int smallerNum = 80;
        double quotient = (double)largerNum / (double)smallerNum;
        System.out.println("\nThe quotient is " + quotient);

        //two doubles...divide larger by smaller, print in various formats
        double biggerNumber = 100.7d;
        double smallerNumber = 109.9d;
        double result  = biggerNumber / smallerNumber;
        System.out.println("\nResult as a double: " + result);
        System.out.println("Result truncated to form an integer: " + Math.floor(result));
        System.out.println("Result rounded to look like an integer: " + Math.round(result));
        int intResult = (int) Math.round(result);
        System.out.println("Result rounded to nearest int, cast, stored as int: " + intResult);

        //Misc. instructions; cast y as a double and assign to q. Print q before and after the re-assignment.
        int x = 5;
        int y = 6;
        double q = y / x;
        System.out.println("\nThe variable q is: " + q);
        q = (double)y;
        System.out.println("The variable q is now: " + q);

        //Smart Meter Roll-out and "customer "Savings"
        final double MULTIPLIER_SMART_METER = 1.2D;
        double analogPowerBill = 300.23;
        double newPowerBill = analogPowerBill * MULTIPLIER_SMART_METER;
        System.out.println("\nWith the accurate analog meter,\n the electric bill was $"
                + analogPowerBill + ". \nHowever, with the new, \"free\" smart meter, the bill with the promised \"savings\" is around $"
                + Math.round(newPowerBill) + ".");

        //The Cafe: Three items with prices, subtotal, total including sales tax, format double with two digits
        double priceMuddyCoffee = 1.95;
        double priceMatchaLatte = 3.50;
        double priceStaleMuffin = 2.75;

        final double MULTIPLIER_SALES_TAX = 1.075;

        double subtotal = (3 * priceMuddyCoffee) + (4 * priceMatchaLatte)
                + (2 * priceStaleMuffin);

        double totalSale = subtotal * MULTIPLIER_SALES_TAX;

        //attempt to format the double to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        totalSale = Double.parseDouble(df.format(totalSale)); //may not half-round to ceiling, though

        System.out.println("\nAt the cafe, the customer's total is $" + totalSale + ", including sales tax.");
    }
}
