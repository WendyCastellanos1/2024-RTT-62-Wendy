package org.example.SBA1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int getDigitsSum(int largeNumber) {

        String myNum = Integer.toString(largeNumber); //put the int in a String

        int sum = 0;

        for (int pos = 0; pos < myNum.length(); pos++) {
            sum = sum + Integer.valueOf(myNum.charAt(pos));
        }

        for(int pos = 0; pos < myNum.length(); pos++){

            //any approach that takes a char from the String: that char turned to int gives ASCII value only
            //this approach keeps the digit chunk as a String, so parseInt works on the String to extract the int
            sum = sum + Integer.parseInt(myNum.substring(pos, pos + 1));
        }
        return sum;
    }
}