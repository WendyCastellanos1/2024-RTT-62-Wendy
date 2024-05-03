package org.example.GLAB_303_3_1;

public class TestStringComparison3 {
    public static void main(String[] args) {
        //compare the values lexicographically
        // returns 0 if this string is the same as another
        // returns <0 if lexicographically less than another
        // OR   returns >0
        String s1 = "Perscholas";
        String s2 = "Perscholas";
        String s3 = "Perschola";
        String s4 = "PerscholasX";
        System.out.println(s1.compareTo(s2)); //0
        System.out.println(s1.compareTo(s3)); // 1 (positive value bc s1>s3)
        System.out.println(s1.compareTo(s4)); // -1 (negative value bc s1<s4)
    }
}
