package org.example.Slides_303_4;

public class WhileLoopsExample {
    public static void main(String[] args) {

        //for loops BOUNDED, when you know what you have, how many, ....
        //while loop: when less certainty, or "just do this until..." is OK

        // infinite loop good for stalling until you want to do something, e.g. hourly
        /*int x;
        while (true) {
            x = x + 1;
            if (x == 10000){
                break;
            }
        }
        */
        //while loop that goes 3x with a break in it will let you try something over and over as exceptions happen
        //while customer waits, e.g. forming series of unique keys in Eric's app.

        //"regular" example
        int x = 1; //initializing outside of the loop
        while ( x < 10) {       //loop just evaluates the condition. if true, runs the code.
            x = x + 1;          // or    x++;
            System.out.println(x);
        }

        String someString = "this is a string";
        for (int pos = 0; pos < someString.length(); pos++){
            System.out.println(someString.charAt(pos));
        }

        //consider O notation (how long something will take based on simplicity/complexity) when working with big lists and nesting loops
        //   or looking at first, then next, etc. for looking. map could be better (upcoming).

    }

}
