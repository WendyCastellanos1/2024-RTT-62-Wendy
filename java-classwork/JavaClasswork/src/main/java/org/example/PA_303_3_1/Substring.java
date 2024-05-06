package org.example.PA_303_3_1;

import java.util.Scanner;

//Wendy Castellanos for PerScholas
//Takes a string and extract a substring using the start & end indices.

    public class Substring {

        public static void main(String[] args) {

            System.out.println("Enter the string, a start index, an end index on single line, space-delimited.");
            Scanner scanner = new Scanner(System.in);
            String S = scanner.next();
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            scanner.close();

            System.out.println(S.substring(start,end));
        }
    }



//
//        import java.io.*;
//        import java.util.*;
//        import java.text.*;
//        import java.math.*;
//        import java.util.regex.*;