package org.example.PA_303_3_1;

public class PracticeAssignmentStrings {

    /* HackerRank:
    Screenshots in the homework folder
    Code copied here, though the inputs are not available here, so don't run!
    TODO: 3rd, 4th, 5th exercises (10:45 pm) and still need to read the slides for tomorrow.
     */
}

//***************************************************************
 /* 1st exercise: Java Strings Introduction
 import java.io.*;
import java.util.*;
import java.lang.String;

public class Solution { //Wendy Castellanos for PerScholas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        int sum = A.length() + B.length(); //9 (correct)
        System.out.println(sum);
        int result = A.compareTo(B);
        String answer = new String();
        if (result >=0){answer = "Yes";}
        else{answer = "No";}
        System.out.println(answer); //No (correct)
        //TODO: Change next line to capitalize only first letter
        System.out.println(A.toUpperCase() + " " + B.toUpperCase());
        scanner.close(); //HELLO JAVA  should be Hello Java (TODO)
    }
}
*/
/*String newA = new String();
        int i;
        for(i=0; i<A.length(); i++){
            if (i == 0){
                A.charAt(0).toUpperCase();
            }
            newA = A + A.charAt(i);
        }
        System.out.println(newA); */
//**************************************************************
/* 2nd exercise: Java Substring
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution { //Wendy Castellanos for PerScholas

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.close();
        System.out.println(S.substring(start,end));
    }
}
 */
//****************************************************
/*
/* 3rd exercise: Java Substring Comparisons
 */

//****************************************************
/*
/* 4th exercise: Java String Reverse
 */

//****************************************************
/*
/* 5th exercise: Java String Tokens
 */