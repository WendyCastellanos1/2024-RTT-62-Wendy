package org.example.Slides_303_4;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;


public class ForLoopExample {
    public static void main(String[] args) {

        for ( int count = 1; count < 10; count++){
            System.out.println("The count is: " + count);
            //any line of code can be in here
        }

        for (int i = 0; i < 2; i++){
            System.out.println("i is: " + i);
        }
        //this is an old school for loop
        for ( int count = 1; count < 10; count++){
                for (int d = 0 ; d<5 ; d++){
                    System.out.println("d is " + d);
                }
            //could nest a for loop here
            System.out.println("The count is: " + count);

            if (count % 2 == 0){
                System.out.println("Count is an even number.");
            }
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Two");
        stringList.add("Three");
        stringList.add("Four");
        stringList.add("Five");

        //we can use an old style for loop to move across this list
        for (int pos = 0 ; pos < stringList.size(); pos++) {
            System.out.println(stringList.get(pos));
        }

        //new, now dominant style of loop (but use old for mathematical precision re: position in list, etc.)
        //when you don't care about POSITION in the list, or use this with an int counter and counter++ at end.
       /* for (String element : stringList){
            System.out.println(element);
            if (element.equals == "three"){         //example of if statement in a for loop
                break; //can do this if it makes sense
                //continue; //sends you back to the top of for loop directly, not execute anything below now
            }
        }
        //e.g. concept: for user in users
        */

    }
}
