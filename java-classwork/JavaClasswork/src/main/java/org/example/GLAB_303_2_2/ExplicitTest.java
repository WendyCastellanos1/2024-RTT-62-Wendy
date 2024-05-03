package org.example.GLAB_303_2_2;

import javax.swing.*;

public class ExplicitTest {
    public static void main(String[] args) {

        double d = 100.04;
        //explicit type casting
        long l = (long)d;
        int i = (int)l;
        System.out.println("Double value " + d); //see that decimal portion is there
        System.out.println("Long value " + l); //explicit cast to long truncates decimal
        System.out.println("Integer value " + i); //explicit cast to int is uneventful here

        byte b;
        int z = 257;
        double dou = 323.142;
        System.out.println("Conversion of int to byte.");
        b = (byte)z; //z = 257 b = 1  bc 1 is remainder of 257/256 (range of byte).
        System.out.println("z = " + z + " b = " + b);

        System.out.println("Conversion of double to int.");
        z = (int)dou;   //dou = 323.142 z = 323
        System.out.println("dou = " + dou + " z = " + z);

        System.out.println("Conversion of double to byte.");
        //dou = 323.142 b = 67 bc fraction lost and value reduced to module 256, which is 67.
        b = (byte)dou;
        System.out.println("dou = " + dou + " b = " + b);
    }
}
