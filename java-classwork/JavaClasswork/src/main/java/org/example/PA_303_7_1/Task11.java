package org.example.PA_303_7_1;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many favorite things do you own? Answer with a single integer.");
        int answer = scanner.nextInt();

        //create an array of the size indicated by answer
        String[] favoriteThings = new String[answer];
        for (int pos = 0; pos < answer; pos++) {
            System.out.println("Name *one* favorite thing (one word).");
            if (scanner.hasNext()) {
                favoriteThings[pos] = scanner.next();
            }
        }
        //print out the contents of the array
        System.out.println("Your " + answer + " favorite things are: ");   // + Arrays.toString(favoriteThings) + ".");
        String listOfThings = "";
        for (String favoriteThing : favoriteThings) {
            listOfThings = listOfThings + " " + favoriteThing;
        }
        System.out.println(listOfThings);

    }


}
