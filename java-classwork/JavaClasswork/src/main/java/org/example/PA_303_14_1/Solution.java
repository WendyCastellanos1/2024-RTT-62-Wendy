package org.example.PA_303_14_1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    @FunctionalInterface
    public interface stringManipulator {
        String removeDigits(String text);
    }

    @FunctionalInterface
    public interface introduceThem {
        void introduce(String name);
    }

    @FunctionalInterface
    public interface greetThem {
        void greet(String name);
    }

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        //remove digits
        stringManipulator digs = (str) -> str.replaceAll("\\d", "");
        String name = digs.removeDigits(text);

        //introduce
        introduceThem intro = (str) -> System.out.println("This is my friend " + str + ".");
        intro.introduce(name);

        //greet
        greetThem greeting = (str) -> System.out.println("Hello, " + str + "!");
        greeting.greet(name);

    }
}