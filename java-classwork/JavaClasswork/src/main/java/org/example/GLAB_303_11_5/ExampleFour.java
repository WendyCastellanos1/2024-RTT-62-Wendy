package org.example.GLAB_303_11_5;

/* Example Four: Enhanced for() Loop

Remember: HashSet DOES NOT maintain any order, and does NOT keep duplicates;
so this order might be changed if you run your code a second time.  */

import java.util.HashSet;

public class ExampleFour {

    public static void main(String args[]) {

        // HashSet declaration
        HashSet<String> hset = new HashSet<String>();

        // Adding elements to the HashSet
        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");

        //Addition of duplicate elements
        hset.add("Apple");
        hset.add("Mango");

        //Addition of null values
        hset.add(null);
        hset.add(null);

        // Using advanced for loop
        for (String str : hset) {
            System.out.println(" ---> " + str);
        }
    }
}
/* Output:

---> null
 ---> Apple
 ---> Grapes
 ---> Fig
 ---> Mango
 ---> Orange

Process finished with exit code 0
*/