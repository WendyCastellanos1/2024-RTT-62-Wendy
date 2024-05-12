package org.example.GLAB_303_11_5;

/* Example two: Remove Elements
● remove() - removes the specified element from the set.
● removeAll() - removes all of the elements from the set. */

import java.util.TreeSet;

public class TreesetExampleTwo {

    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);

        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        // Using the removeAll() method
        boolean value2 = numbers.removeAll(numbers);
        System.out.println("Are all elements removed? " + value2);
    }
}
/* Output:
TreeSet: [2, 5, 6]
Is 5 removed? true
Are all elements removed? true

Process finished with exit code 0
*/