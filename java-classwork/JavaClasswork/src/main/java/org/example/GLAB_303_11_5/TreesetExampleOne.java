package org.example.GLAB_303_11_5;

/* Example one: Iterate Through TreeSet.
To access the individual elements of TreeSet, we need to iterate
through the TreeSet —— traverse through the TreeSet. We do this by
declaring an Iterator for the TreeSet, and then use that Iterator to
access each element. For this, we use the next() method of an
iterator that returns the next element in the TreeSet.
The following Java program demonstrates the use of the Iterator to
iterate through TreeSet */

import java.util.TreeSet;
import java.util.Iterator;

public class TreesetExampleOne {

    public static void main(String[] args) {

        TreeSet<Integer> num_Treeset = new TreeSet<>();
        num_Treeset.add(20);
        num_Treeset.add(5);
        num_Treeset.add(15);
        num_Treeset.add(25);
        num_Treeset.add(10);

        // Call iterator() method to define Iterator for TreeSet
        Iterator<Integer> iter_set = num_Treeset.iterator();

        System.out.print("TreeSet using Iterator: ");

        // Access TreeSet elements using Iterator
        while(iter_set.hasNext()) {
            System.out.print(iter_set.next());
            System.out.print(", ");
        }
    }
}
/* Output:
TreeSet using Iterator: 5, 10, 15, 20, 25,  //put them in order

Process finished with exit code 0
 */