package org.example.PA_303_2_2;
import java.util.Scanner;

public class HackerRank_Stdin_and_Stdout_II {
    //my code copied from HackerRank, no input files here, so don't run it

    public static void main(String[] args) {
        //Wendy Castellanos for PerScholas
        //String s1 = new String();

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s1 = scan.nextLine();

        System.out.println("String: " + s1);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

        scan.close();
    }
}
