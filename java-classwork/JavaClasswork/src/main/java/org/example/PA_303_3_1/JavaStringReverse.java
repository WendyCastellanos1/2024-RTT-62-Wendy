package org.example.PA_303_3_1;

import java.io.*;
import java.util.*;

//Wendy Castellanos for PerScholas

public class JavaStringReverse {

    public static void main(String[] args) {

        String original, reverse = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string/number to check if it is a palindrome");

        original = scanner.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        if (original.equals(reverse)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

