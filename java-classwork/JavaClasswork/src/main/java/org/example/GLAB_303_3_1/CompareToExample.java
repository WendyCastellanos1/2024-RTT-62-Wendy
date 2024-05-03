package org.example.GLAB_303_3_1;

public class CompareToExample {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hemlo";
        String s4 = "flag";
        System.out.println(s1.compareTo(s2)); // o because both are equal
        System.out.println(s1.compareTo(s3)); //-1 bc "L" is only one time Lower than "m"
        System.out.println(s1.compareTo(s4)); // 2 because "h" is 2x greater than "f"
    }
}
