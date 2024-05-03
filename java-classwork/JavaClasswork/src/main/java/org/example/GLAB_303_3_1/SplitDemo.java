package org.example.GLAB_303_3_1;
import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String letters = "a::b::c::d:e";

        // splittting the string at "::"
        // storing the result in an array of strings
        String[] result = letters.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));

        //result = [a, b, c, d:e]
    }
}
