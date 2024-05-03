package org.example.GLAB_303_3_1;

import java.awt.*;

public class ReplaceDemoMain {
    public static void main(String[] args) {
        String str1 = "abc cab";

        // all occurrences of 'a' is replaced with 'z'
        System.out.println(str1.replace('a', 'z')); //zbc czb

        // all occurrences of 'L' is replaced with 'J'
        System.out.println("Lava".replace('L', 'J')); //Java

        // character not in the string
        System.out.println("Hello".replace('4', 'J')); //Hello

        // all occurrences of "C++" is replaced with "Java"));
        System.out.println(str1.replace("C++", "Java")); //abc cab

        // all occurrences of "aa" is replaced with "zz"
        System.out.println("aa bb aa zz".replace("aa", "zz")); //zz bb zz zz

        // substring not in the string
        System.out.println("Java".replace("C++", "C")); //Java
    }
}
