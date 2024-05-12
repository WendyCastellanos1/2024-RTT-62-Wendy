package org.example.GLAB_303_11_5;

/* Example Three: Methods for Navigation.
Since the TreeSet class implements NavigableSet, it provides various
methods to navigate over the elements of the TreeSet.
1. first() and last() Methods
● first() - returns the first element of the set.
● last() - returns the last element of the set. */

import java.util.TreeSet;

public class TreesetExampleThree {

    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);

        // Using the first() method
        int first = numbers.first();
        System.out.println("First Number: " + first);

        // Using the last() method
        int last = numbers.last();
        System.out.println("Last Number: " + last);
    }
}
/* Output:
TreeSet: [2, 5, 6]
First Number: 2
Last Number: 6

Process finished with exit code 0
*/
