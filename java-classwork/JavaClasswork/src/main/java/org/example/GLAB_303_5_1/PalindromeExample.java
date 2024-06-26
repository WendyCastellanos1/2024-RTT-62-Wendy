package org.example.GLAB_303_5_1;

import java.util.Scanner;

public class PalindromeExample {

    public static void main(String[] args) {

        String original, reverse = ""; // objects of the String class

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string/number to check if it is a palindrome");

        original = in.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }
        if (original.equals(reverse)) {
            //it is a palindrome
            System.out.println("Entered string/number is a palindrome.");
        } else {
            //it is not a palindrome
            System.out.println("Entered string/number isn't a palindrome.");
        }
    }
}
