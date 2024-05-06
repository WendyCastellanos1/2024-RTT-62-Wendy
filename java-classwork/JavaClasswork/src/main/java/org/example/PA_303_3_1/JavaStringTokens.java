package org.example.PA_303_3_1;

import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.Scanner;

//lesson: split function uses regex to split into tokens stored in a String array
//String[] tokens = S.split("[^a-zA-Z]");

public class JavaStringTokens {     // public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a single string, like: He is a very very good boy, isn't he?  ");
        String s = scan.nextLine();

        //String regex = "[A-Za-z !,?._'@]+";      // or ?    [A-Za-z !,?._'@]+,  comma or no?

        //split string into tokens
       String[] tokenArray = s.split( "[A-Za-z!,?._'@]+"); //doesn't work
        //String[] tokenArray = s.split( "\s");

        int numTokens = 0;

        for (int i = 0; i < tokenArray.length; ++i){
            if (!tokenArray[i].isEmpty()) {
                numTokens++;
            }
        }
        System.out.println(numTokens);

        for (int i = 0; i < tokenArray.length; ++i){
            if (!tokenArray[i].isEmpty()){
                System.out.println(tokenArray[i]);
            }
        }
        scan.close();
    }
}
