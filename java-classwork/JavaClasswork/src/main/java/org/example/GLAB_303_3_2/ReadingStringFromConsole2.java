package org.example.GLAB_303_3_2;
import java.util.Scanner;

public class ReadingStringFromConsole2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String s = input.nextLine();
        char ch = s.charAt(0); //picks up the ONLY character, or the first if you type several
        System.out.println( "The character entered is " + ch);
        input.close();
    }
}
