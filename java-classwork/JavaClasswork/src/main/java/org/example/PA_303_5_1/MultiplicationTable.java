package org.example.PA_303_5_1;

public class MultiplicationTable {

    public static void main(String[] args) {

        for (int x = 1; x <= 12; x++) {
            for (int y = 1; y <= 12; y++) {
                System.out.print(x * y + "\t");
            }
            System.out.println();
        }
    }
}
