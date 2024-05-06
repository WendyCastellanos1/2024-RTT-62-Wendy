package org.example.PA_303_3_1;

import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.Scanner;

//Wendy Castellanos for PerScholas

public class JavaStringsIntroduction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two strings, each on a separate line");   //test case 0:  hello  java
        String A = scanner.next();
        String B = scanner.next();

        int sum = A.length() + B.length(); //9 (correct)
        System.out.println(sum);

        int result = A.compareTo(B);
        String answer = new String();

        if (result > 0) {       //means strings not the same, and first "greater" than the other (a < z)
            answer = "Yes";
        } else {
            answer = "No";
        }
        System.out.println(answer); //No (correct)

        //capitalize the first letter of each word
        //word 1
        String substringFirst = A.substring(0, 1);
        String substringRestOfWord = A.substring(1, A.length());

        //re-assign variable A with re-constructed string
        A = substringFirst.toUpperCase() + substringRestOfWord;

        //Separate first letter and rest of word in B
        substringFirst = B.substring(0, 1);
        substringRestOfWord = B.substring(1, B.length());

        //re-assign variable B with re-constructed string
        B = substringFirst.toUpperCase() + substringRestOfWord;

        //should be Hello Java for test case 0
        System.out.println(A + " " + B);

        scanner.close();
    }
}
